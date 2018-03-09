class Client {
  MeterArchine m = new MeterArchine ();

  public void mainMethod () {
    Clock       c = new Clock ((float) 0.01);
    Thermometer t = new Thermometer ((float) -273.15, Float.MAX_VALUE);
    Scale       s = new Scale (200, 200 * 1000);

    m.put("M1", c);
    m.put("M2", t);
    m.put("M3", s);

    System.out.println
      ( m.vandalize("M2")
     && m.move("M2", "M3")
      );

    // Should neither work, nor crash
    System.out.println
      ( m.vandalize("M4")
     || m.move("M4", "M3")
      );

    Meter tst = m.get("M3");
    System.out.println(tst.toString());
  }
}
