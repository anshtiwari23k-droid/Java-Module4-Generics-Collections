/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Advanced Q3 - WeakHashMap entries removed after keys lose strong references
 */
package advanced;

import java.util.WeakHashMap;

public class Q03_WeakHashMapGC {

    static class SessionKey {
        final String user;
        SessionKey(String user) { this.user = user; }
        public String toString() { return "Key(" + user + ")"; }
    }

    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<SessionKey, String> cache = new WeakHashMap<>();

        SessionKey ansh = new SessionKey("ansh");
        SessionKey riya = new SessionKey("riya");
        SessionKey karan = new SessionKey("karan");
        cache.put(ansh, "session-data-A");
        cache.put(riya, "session-data-R");
        cache.put(karan, "session-data-K");
        System.out.println("Initially: " + cache);

        // Drop strong references to two keys; 'ansh' is still strongly referenced
        riya = null;
        karan = null;
        System.out.println("Set riya and karan references to null, calling System.gc() ...");

        for (int i = 0; i < 10 && cache.size() > 1; i++) {
            System.gc();
            Thread.sleep(100);
        }
        System.out.println("After GC : " + cache);
        System.out.println("Only " + ansh + " is left because it is still strongly referenced.");
    }
}
