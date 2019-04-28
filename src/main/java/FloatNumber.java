public class FloatNumber implements FloatInput {
    private int capacity;
    private float number = 0;

    FloatNumber(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean put(char c) {
        if(toString().length() >= capacity) return false;
        if(getFloat() == 0.0f) {
            // Eine 0.0 kann kein Vorzeichen bekommen
            if((c == '+' || c == '-')) return false;
            // Keine führenden Nullen
            if(c == '0') return true;
        }
        // keine mehrfachen Kommata
        if(c=='.' && toString().contains(".")) return false;
        number = Float.parseFloat(toString() + c);
        return true;
    }

    @Override
    public float getFloat() {
        return number;
    }

    @Override
    public void undo() {
        if(number == 0) return;
        number = Float.parseFloat(toString().substring(0, toString().length() - 1));
    }

    @Override
    public String toString() {
        if(number % 1f == 0) return Integer.toString((int) number);
        return Float.toString(number);
    }
}
