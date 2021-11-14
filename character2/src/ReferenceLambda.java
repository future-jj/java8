import java.util.function.Function;

public class ReferenceLambda {
    public static void main(String[] args) {
        Function <Integer,Integer> f=x->x+1;
        Function <Integer,Integer> g=x->x*2;
        Function<Integer,Integer> h=f.andThen(g);
        // 先计算f然后再去计算g
        int result=h.apply(12);
        System.out.println(result);
        Function<Integer,Integer> r=f.compose(g);
        //先计算g再去计算f
        result=r.apply(12);
        System.out.println(result);

    }



}
