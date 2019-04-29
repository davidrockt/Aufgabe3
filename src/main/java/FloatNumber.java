public class FloatNumber implements FloatInput {
    private int capacity;
    private String number = "0";
    private String permittedInput = "0123456789.";

    FloatNumber(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean put(char c) {
        if(toString().length() >= capacity || !permittedInput.contains(Character.toString(c))) {
            return false;
        }
        if(toString().equals("0")) {
            // Keine führenden Nullen
            if(c == '0') return true;
            if(c >= '0' && c <= '9') {
                number = "" + c;
                return true;
            }
        }
        // keine mehrfachen Kommata
        if(c=='.' && toString().contains(".")) return false;
        number += c;
        return true;
    }

    @Override
    public float getFloat() {
        return Float.parseFloat(number);
    }

    @Override
    public void undo() {
        if(number.equals("0")) return;
        number = number.substring(0, toString().length() - 1);
    }

    @Override
    public String toString() {
        // if(getFloat() % 1f == 0) return Integer.toString((int) number);
        return number;
    }
}
