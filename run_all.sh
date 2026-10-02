#!/usr/bin/env bash
# Compiles every program and runs each one, saving output to outputs/<package>.<Class>.txt
# Interactive programs read their sample input from inputs/<package>.<Class>.txt
cd "$(dirname "$0")"
rm -rf bin && mkdir -p bin outputs
javac -d bin $(find src -name '*.java') || exit 1
for f in $(find src -name 'Q*.java' | sort); do
  cls=$(echo "${f#src/}" | sed 's/\.java$//; s#/#.#g')
  in="inputs/$cls.txt"
  echo "== $cls"
  if [ -f "$in" ]; then java -cp bin "$cls" < "$in" > "outputs/$cls.txt" 2>&1
  else java -cp bin "$cls" > "outputs/$cls.txt" 2>&1; fi
done
