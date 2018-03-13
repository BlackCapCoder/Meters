abstract class Meter {

  public abstract float  getMinValue ();
  public abstract float  getMaxValue ();
  public abstract String getUnit     ();


  private Boolean broken = false;

  public Boolean getBroken (         ) { return broken; }
  public void    setBroken (Boolean b) { broken = b; }
  public void toggleBroken (         ) { broken = !broken; }


  private String reg;
  private String pos;

  public String getReg () { return reg; }
  public String getPos () { return pos; }
  public void setReg (String x) { reg = x; }
  public void setPos (String x) { pos = x; }


  public Meter (String reg, String pos) {
    this.reg = reg;
    this.pos = pos;
  }


  public Boolean equals (Meter b) {
    Meter a = this;

    if (a.getClass() != b.getClass()) return false;

    return a.getMinValue() == b.getMinValue()
        && a.getMaxValue() == b.getMaxValue()
        && a.getReg()      == b.getReg()
        && a.getPos()      == b.getPos()
         ;
  }

  public String toString () {
    String name = this.getClass().getName();

    return name + "\n"
         + "intv: " + Float.toString(this.getMinValue())
         + " - "    + Float.toString(this.getMaxValue())
         + " " + this.getUnit().toLowerCase() + "\n"
         + "reg:  " + this.getReg() + "\n"
         + "pos:  " + this.getPos() + "\n"
         + "stat: " + (this.getBroken() ? "broken!" : "fine")
         ;
  }
}
