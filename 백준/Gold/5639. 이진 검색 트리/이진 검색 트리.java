import javax.naming.BinaryRefAddr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int idx;

    public static void main(String[] args) throws IOException {
        final int LEFT = 0, RIGHT = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        List<Integer> nums = new ArrayList<>();
        BinaryTree binaryTree = null;
        while (true) {
            str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }

            int n = Integer.parseInt(str);
            if(binaryTree == null) binaryTree = new BinaryTree(n);
            else binaryTree.insert(n);
        }

        System.out.println(binaryTree);

        br.close();
    }
}

class BinaryTree {
    int num;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(boolean isRoot) {}
    public BinaryTree(int num) {
        this.num = num;
    }

    public void insert(int n){
        if(this.num > n){
            if(this.left == null) this.left = new BinaryTree(n);
            else this.left.insert(n);
        }
        else{
            if(this.right == null) this.right = new BinaryTree(n);
            else this.right.insert(n);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        getString(sb);

        return sb.toString();
    }

    private void getString(StringBuilder sb) {
        if(left != null) left.getString(sb);
        if(right != null) right.getString(sb);
        sb.append(num + "\n");
    }
}