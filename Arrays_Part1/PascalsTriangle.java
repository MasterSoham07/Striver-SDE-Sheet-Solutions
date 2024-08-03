import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public ArrayList<Integer> generateRow(int row){
        int ans = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int col = 1; col < row; col++){
            ans = ans * (row - col);
            ans = ans / (col);
            arr.add(ans);
        }

        return arr;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            ans.add(generateRow(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();
        int n = 5;
        System.out.println(obj.generate(n));
    }
}
