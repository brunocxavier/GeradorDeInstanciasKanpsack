import java.io.*;
import java.util.Random;

public class App {
    public static void main(String[] args) throws IOException {
        int n = 5000000;
        int capacity = 10000;
        BufferedWriter bwJson = new BufferedWriter(new FileWriter("n_" + n + "_max_" + capacity + "_json.txt"));
        try {
            StringBuilder valores = new StringBuilder();
            valores.append("[");
            StringBuilder pesos = new StringBuilder();
            pesos.append("[");
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                int valor = 1 + Math.abs(random.nextInt() % 1000);
                int peso = 1 + Math.abs(random.nextInt()) % (capacity/4);
                if (i == n - 1){
                    valores.append(valor);
                    pesos.append(peso);
                } else {
                    valores.append(valor).append(", ");
                    pesos.append(peso).append(", ");
                }
            }
            valores.append("]");
            pesos.append("]");
            StringBuilder sb1 = new StringBuilder();
            sb1.append("{");
            sb1.append("\"numberOfItems\":");
            sb1.append(n);
            sb1.append(",");
            sb1.append("\n");
            sb1.append("\"capacity\":");
            sb1.append(capacity);
            sb1.append(",");
            sb1.append("\n");
            sb1.append("\"values\":");
            sb1.append(valores);
            sb1.append(",");
            sb1.append("\n");
            sb1.append("\"weights\":");
            sb1.append(pesos);
            sb1.append("}");
            bwJson.write(sb1.toString());
        } finally {
            bwJson.close();
        }
    }
}
