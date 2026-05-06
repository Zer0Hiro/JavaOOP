package Forest;

public class MainForForest {
    public static void main(String[] args) {
        Tree[] a = new Tree[4];
        a[0] = new FigTree();
        a[1] = new OrangeTree();
        a[2] = new FigTree();
        a[3] = new NamedFigTree("Buba");
        Forest f = new Forest(a);
        System.out.println(f);
        for (int i = 0; i < 10; i++)
            System.out.print(f.totalCost(i) + " ");

    }
}
