import java.util.Stack;

public class Main {

    static class pair{
        int element,index;
        pair(int a, int b){
            this.element = a;
            this.index = b;
        }
    }

    public static void stockSpan(int[] a){
        int[] result = new int[a.length];
        Stack<pair> stack = new Stack<>();
        
        for(int i = 0; i<a.length; i++){
            if(stack.size()==0){
                result[i] = -1;
            } else if (stack.size()!=0 && stack.peek().element>a[i]) {
                result[i] = stack.peek().index;
            } else if (stack.size()!=0 && stack.peek().element<=a[i]) {
                while (stack.size()!=0 && stack.peek().element<=a[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    result[i] = -1;
                } else {
                    result[i] = stack.peek().index;
                }
            }
            stack.push(new pair(a[i], i));
        }
        
        
        for(int i=0;i<result.length;i++){
            result[i] = i-result[i];
        }

        for(int i=0;i<result.length;i++){
            System.out.print(" "+result[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {100,80,60,70,60,75,85};
        stockSpan(array);
    }
}