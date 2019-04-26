interface FloatInput {
    boolean put(char c); // input char by char, true if char is accepted
    float getFloat();    // get float value of input for computations
    void undo();         // undo last input if there are chars left
    String toString();   // get string representation of input
}

