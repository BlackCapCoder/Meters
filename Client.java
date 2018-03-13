class Client {
  MeterArchine m = new MeterArchine ();

  public void mainMethod () {
    Clock       c = new Clock       ("C", "M1", (float) 0.01);
    Thermometer t = new Thermometer ("T", "M2", (float) -273.15, Float.MAX_VALUE);
    Scale       s = new Scale       ("S", "M3", 200, 200 * 1000);

    m.put(c);
    m.put(t);
    m.put(s);

    System.out.println
      ( m.vandalize("T")
     && m.move("T", "M3")
      );

    // Should neither work, nor crash
    System.out.println
      ( m.vandalize("Q")
     || m.move("Q", "M3")
      );

    System.out.println();

    Meter tst = m.getByPos("M3");
    System.out.println
      ( tst==null
      ? "Nothing here"
      : tst.toString()
      );
  }
}
