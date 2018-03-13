abstract class Meter {
  private Boolean broken = false;

  public abstract float  getMinValue ();
  public abstract float  getMaxValue ();
  public abstract String getUnit     ();

  public void    setBroken (Boolean b) { broken = b; }
  public Boolean getBroken (         ) { return broken; }
  public void toggleBroken (         ) { broken = !broken; }

  private String ID;
  public String getID () { return ID; }
  public void setID (String id) { this.ID = id; }


  public Meter (String id) {
    this.ID = id;
  }


  public Boolean equals (Meter b) {
    Meter a = this;

    if (a.getClass() != b.getClass()) return false;

    return a.getMinValue() == b.getMinValue()
        && a.getMaxValue() == b.getMaxValue()
        && a.getID()       == b.getID()
         ;
  }

  public String toString () {
    String name = this.getClass().getName();

    return name + ":" + this.ID + ", measures "
         + Float.toString(this.getMinValue()) + "-"
         + Float.toString(this.getMaxValue()) + " "
         + this.getUnit().toLowerCase()
         + (this.getBroken() ? ", broken" : "")
         ;
  }
}
