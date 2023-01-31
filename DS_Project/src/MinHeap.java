// === MinHeap ===
class MinHeap {

    // ========== Attributes ==========
    private Restaurant[] Heap;
    private int size;
    private int maxsize;
    // Initializing front as static with unity
    private static final int FRONT = 1;

    // ========== Getters Setters ==========
    public Restaurant[] getHeap() {
        return Heap;
    }

    public void setHeap(Restaurant[] heap) {
        Heap = heap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }
    // ========== ========== ==========


    // ========== Constructor ==========
    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        // initial our heap with an element(restaurant) with a minimum
        // value in order to never find it-self a new father or bigger
        // brother.
        Heap = new Restaurant[this.maxsize + 1];
        Restaurant tempRestaurant = new Restaurant("TopRestaurant", Integer.MIN_VALUE);
        Heap[0] = tempRestaurant;
    }


    // Returning the position of the parent for the node currently at pos
    private int parent(int pos) {
        return pos / 2;
    }

    // Returning the position of the left child for the node currently at pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Returning the position of the right child for the node currently at pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Returning true if the passed node is a leaf node
    private boolean isLeaf(int pos) {

        if (pos > (size / 2)) {
            return true;
        }

        return false;
    }

    // To swap two nodes of the heap
    private void swap(int fpos, int spos) {

        Restaurant tmp;
        tmp = Heap[fpos];

        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // To heapify the node at pos
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int swapPos = pos;
            // swap with the minimum of the two children
            // to check if right child exists. Otherwise default value will be '0'
            // and that will be swapped with parent node.
            if (rightChild(pos) <= size)
                swapPos = Heap[leftChild(pos)].getRestaurantDistance() < Heap[rightChild(pos)].getRestaurantDistance() ?
                        leftChild(pos) : rightChild(pos);
            else
                swapPos = leftChild(pos);

            if (Heap[pos].getRestaurantDistance() > Heap[leftChild(pos)].getRestaurantDistance() ||
                    Heap[pos].getRestaurantDistance() > Heap[rightChild(pos)].getRestaurantDistance()) {
                swap(pos, swapPos);
                minHeapify(swapPos);
            }

        }
    }

    // To insert a node into the heap
    public void insert(Restaurant element) {

        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current].getRestaurantDistance() < Heap[parent(current)].getRestaurantDistance()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // To print the contents of the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + Heap[i].getRestaurantName()
                            + " LEFT CHILD : " + Heap[2 * i].getRestaurantName().toString()
                            + " RIGHT CHILD :" + ((Heap[2 * i + 1] != null) ?
                            Heap[2 * i + 1].getRestaurantName() : "null"));
            /// ((phone!=null)?phone:" number not found !"
            // By here new line is required
            System.out.println();
        }
    }

    // To remove and return the minimum element from the heap
    public Restaurant remove() {

        Restaurant popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);

        return popped;
    }

}

