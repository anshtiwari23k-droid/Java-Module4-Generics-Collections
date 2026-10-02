# Windows PowerShell: compiles every program and runs each one,
# saving output to outputs\<package>.<Class>.txt
# Interactive programs read their sample input from inputs\<package>.<Class>.txt
Set-Location $PSScriptRoot
if (Test-Path bin) { Remove-Item bin -Recurse -Force }
New-Item -ItemType Directory -Force -Path bin, outputs | Out-Null
$files = Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -d bin $files
if ($LASTEXITCODE -ne 0) { exit 1 }
Get-ChildItem -Path src -Recurse -Filter Q*.java | Sort-Object FullName | ForEach-Object {
    $cls = "$($_.Directory.Name).$($_.BaseName)"
    $in = "inputs\$cls.txt"
    Write-Host "== $cls"
    if (Test-Path $in) { Get-Content $in | java -cp bin $cls > "outputs\$cls.txt" 2>&1 }
    else { java -cp bin $cls > "outputs\$cls.txt" 2>&1 }
}
