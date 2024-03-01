import java.util.Scanner;
public class Algo358 {
    public static void main(String[] args) {
        float[] precocompra = new float[100], precovenda = new float[100];
        float lucro;
        int totlucromenor10, totlucromenor20, totlucromaior20;
        Scanner scanner = new Scanner(System.in);
        totlucromenor10 = 0;
        totlucromaior20 = 0;
        totlucromenor20 = 0;
        for(int i = 0; i < 100; i++){
            System.out.println("Preco de compra: \n");
            precocompra[i] = scanner.nextInt();
            System.out.println("Preco de venda: \n");
            precovenda[i] = scanner.nextInt();
        }
        for(int i = 0; i < 100; i++){
            lucro = precovenda[i] - precocompra[i];
            if((lucro/precocompra[i])*100 < 10.0){
                totlucromenor10++;
            } else if((lucro/precocompra[i])*100 <= 20.0){
                totlucromenor20++;
            } else{
                totlucromaior20++;
            }
        }
        System.out.println("Total de mercadorias com lucro < 10%: " + totlucromenor10);
        System.out.println("Total de mercadorias com 10 <= lucro <= 20%: " + totlucromenor20);
        System.out.println("Total de mercadorias com lucro > 20%: " + totlucromaior20);
    }
}
