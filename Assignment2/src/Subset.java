public class Subset {

    public static void main(String[] args) {
        RandomizedQueue<String> r = new RandomizedQueue<>();
        int k = StdIn.readInt();
        while (!StdIn.isEmpty()) {
            r.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(r.dequeue());
        }
    }
}