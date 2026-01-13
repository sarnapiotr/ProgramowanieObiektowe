public class Lab4 {
    public static String infixToONP(String expr) {
        expr = expr.replace("=", "");
        StringBuilder out = new StringBuilder();

        String[] stos = new String[expr.length()];
        int top = -1;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    out.append(expr.charAt(i));
                    i++;
                }
                i--;
                out.append(" ");
            }
            else if (c == '(') {
                stos[++top] = "(";
            }
            else if (c == ')') {
                while (top >= 0 && !stos[top].equals("(")) {
                    out.append(stos[top]).append(" ");
                    top--;
                }
                top--;
            }
            else {
                String op = String.valueOf(c);
                while (top >= 0 && priority(stos[top]) >= priority(op)) {
                    out.append(stos[top]).append(" ");
                    top--;
                }
                stos[++top] = op;
            }
        }

        while (top >= 0) {
            out.append(stos[top]).append(" ");
            top--;
        }

        return out.toString().trim();
    }

    public static int priority(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }

    public static double evaluateONP(String onp) {
        String[] tokens = onp.split(" ");
        String[] stos = new String[tokens.length];
        int top = -1;

        for (String t : tokens) {
            if (t.matches("\\d+")) {
                stos[++top] = t;
            }
            else {
                double b = Double.parseDouble(stos[top--]);
                double a = Double.parseDouble(stos[top--]);
                double wynik = 0;

                if (t.equals("+")) wynik = a + b;
                else if (t.equals("-")) wynik = a - b;
                else if (t.equals("*")) wynik = a * b;
                else if (t.equals("/")) wynik = a / b;

                stos[++top] = String.valueOf(wynik);
            }
        }
        return Double.parseDouble(stos[top]);
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Podaj równania jako argumenty programu, np.:");
            System.out.println("(3+12)*8/2=  2*(11-8)=  3*(11-9)/4=");
            return;
        }

        for (String expr : args) {
            System.out.println("Równanie: " + expr);

            String onp = infixToONP(expr);
            System.out.println("ONP: " + onp);

            double wynik = evaluateONP(onp);
            System.out.println("Wynik: " + wynik);

            System.out.println();
        }
    }
}