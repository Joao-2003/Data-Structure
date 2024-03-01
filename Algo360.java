import java.util.*;

public class Algo360 {
    public static void main(String[] args) {
        LinkedHashMap<String, String> signos = new LinkedHashMap<>();
        signos.put("0120", "Capricornio");
        signos.put("0219", "Aquario");
        signos.put("0320", "Peixes");
        signos.put("0420", "Aries");
        signos.put("0520", "Touro");
        signos.put("0620", "Gemeos");
        signos.put("0721", "Cancer");
        signos.put("0822", "Leao");
        signos.put("0922", "Virgem");
        signos.put("1022", "Libra");
        signos.put("1121", "Escorpiao");
        signos.put("1221", "Sagitario");
        signos.put("1231", "Capricornio");

        Scanner scanner = new Scanner(System.in);
        String dataNascimento;
        do {
            System.out.println("Digite a data de nascimento (ddmm) ou 9999 para sair:");
            dataNascimento = scanner.nextLine();
            if (!dataNascimento.equals("9999")) {
                String signo = getSigno(dataNascimento, signos);
                System.out.println("O signo é: " + signo);
            }
        } while (!dataNascimento.equals("9999"));
    }

    public static String getSigno(String dataNascimento, LinkedHashMap<String, String> signos) {
        String mesDia = dataNascimento.substring(2) + dataNascimento.substring(0, 2);
        for (Map.Entry<String, String> entry : signos.entrySet()) {
            if (mesDia.compareTo(entry.getKey()) <= 0) {
                return entry.getValue();
            }
        }
        return null;
    }
}
