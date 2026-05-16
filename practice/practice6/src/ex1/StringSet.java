package ex1;

public class StringSet {
    private String[] arr;
    private int num;

    public StringSet(int size) {
        arr = new String[size];
    }

    public void add(String s) throws StringSetFullExpression {
        if (s == null)
            throw new NullPointerException();
        if (arr.length == num)
            throw new StringSetFullExpression();
        arr[num++] = s;
    }

    public boolean contains(String s) {
        if (s == null)
            throw new NullPointerException();
        for (int i = 0; i < num; i++)
            if (arr[i].equals(s))
                return true;
        return false;
    }

}
