/*

System.out.println("Running tests ...");

        try {
        assert false;
        System.out.println("ERROR: You forgot to enable asserts! Type: jshell -R-ea");
        System.exit(1);
        } catch (AssertionError e) {
*/
/* everything is fine if error is thrown *//*

 }

// Numeral aus max. 4 Zeichen (inkl. '.')
        FloatInput n = new FloatNumber(4);
// Initialwert ist 0, woran auch ein undo nichts ändert
        assert n.getFloat() == 0.0f && n.toString().equals("0") : "Test 1";
        n.undo();
        assert n.getFloat() == 0.0f && n.toString().equals("0") : "Test 2";
// Vorzeichen spielen bei Zahleneingabe keine Rolle
        assert !n.put('-');
        assert !n.put('+');
        assert n.getFloat() == 0.0f && n.toString().equals("0") : "Test 3";
// Eingabe führender Nullen bleibt ohne Effekt
        assert n.put('0');
        assert n.getFloat() == 0.0f && n.toString().equals("0") : "Test 4";
        assert n.put('0');
        assert n.getFloat() == 0.0f && n.toString().equals("0") : "Test 5";
// Eingabe 0.34
        assert n.put('.');
        assert n.getFloat() == 0.0f && n.toString().equals("0.") : "Test 6";
        assert n.put('3');
        assert n.getFloat() == 0.3f && n.toString().equals("0.3") : "Test 7";
        assert n.put('4');
        assert n.getFloat() == 0.34f && n.toString().equals("0.34") : "Test 8";
// Mehr als vier Zeichen sind nicht erlaubt
        assert !n.put('5');
// Eingabe in wissenschaftlicher Notation nicht möglich
        n.undo();
        n.undo();
        assert n.getFloat() == 0.0f && n.toString().equals("0.") : "Test 9";
        assert !n.put('E');
        assert !n.put('e');
        assert n.getFloat() == 0.0f && n.toString().equals("0.") : "Test 10";
// Sei besser als der Windows-Taschenrechner
        n.undo();
        assert n.getFloat() == 0.0f && n.toString().equals("0") : "Test 11";
        assert n.put('0');
        assert n.getFloat() == 0.0f && n.toString().equals("0") : "Test 12";
        assert n.put('7');
        assert n.getFloat() == 7.0f && n.toString().equals("7") : "Test 13";
        assert n.put('1');
        assert n.getFloat() == 71.0f && n.toString().equals("71") : "Test 14";


*/
