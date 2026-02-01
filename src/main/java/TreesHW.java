public class Main {

    public static void main(String[] args) {
        BinNode<Integer> t15 = new BinNode<>(15);
        BinNode<Integer> t14 = new BinNode<>(14);
        BinNode<Integer> tree = new BinNode<>(t15, 3, t14);

        BinNode<Integer> t9 = new BinNode<>(9);
        tree.getLeft().setLeft(new BinNode<>(t9, 6, new BinNode<>(7)));
        tree.getLeft().setRight(new BinNode<>(new BinNode<>(34), 56, new BinNode<>(12)));

        System.out.println(tree);

        System.out.println("count = " + countEvenWithoutUnevenSon(tree));

        if (existsEvenWithoutUnevenSon(tree))
            System.out.println("exists at least one valid node");
        else
            System.out.println("no valid node exists");

        if (isAllEvenWithoutUnevenSon(tree))
            System.out.println("all nodes are valid");
        else
            System.out.println("not all nodes are valid");

        System.out.print("print: ");
        printEvenWithoutUnevenSon(tree);
        System.out.println();
    }

    public static void printEvenWithoutUnevenSon(BinNode<Integer> t) {
        if (t == null) return;

        int v = t.getValue();

        boolean leftOk = (!t.hasLeft() || t.getLeft().getValue() % 2 == 0);
        boolean rightOk = (!t.hasRight() || t.getRight().getValue() % 2 == 0);

        if (v % 2 == 0 && leftOk && rightOk)
            System.out.print(v + " ");

        printEvenWithoutUnevenSon(t.getLeft());
        printEvenWithoutUnevenSon(t.getRight());
    }

    public static int countEvenWithoutUnevenSon(BinNode<Integer> t) {
        if (t == null) return 0;

        boolean ok = (t.getValue() % 2 == 0)
                && (!t.hasLeft() || t.getLeft().getValue() % 2 == 0)
                && (!t.hasRight() || t.getRight().getValue() % 2 == 0);

        int leftCount = countEvenWithoutUnevenSon(t.getLeft());
        int rightCount = countEvenWithoutUnevenSon(t.getRight());

        return (ok ? 1 : 0) + leftCount + rightCount;
    }

    public static boolean existsEvenWithoutUnevenSon(BinNode<Integer> t) {
        if (t == null) return false;

        boolean ok = (t.getValue() % 2 == 0)
                && (!t.hasLeft() || t.getLeft().getValue() % 2 == 0)
                && (!t.hasRight() || t.getRight().getValue() % 2 == 0);

        return ok
                || existsEvenWithoutUnevenSon(t.getLeft())
                || existsEvenWithoutUnevenSon(t.getRight());
    }

    public static boolean isAllEvenWithoutUnevenSon(BinNode<Integer> t) {
        if (t == null) return true;

        if (t.getValue() % 2 != 0) return false;
        if (t.hasLeft() && t.getLeft().getValue() % 2 != 0) return false;
        if (t.hasRight() && t.getRight().getValue() % 2 != 0) return false;

        return isAllEvenWithoutUnevenSon(t.getLeft())
                && isAllEvenWithoutUnevenSon(t.getRight());
    }
}
