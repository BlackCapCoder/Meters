import java.util.HashMap;

class MeterArchine extends HashMap<String, Meter> {

  public Boolean move (String old, String _new) {
    if (!this.containsKey(old)) return false;

    Meter a = this.get(old);
    Meter b = this.get(_new);

    if (b != null) this.remove(_new);
    this.put(_new, a);
    this.remove(old);
    if (b != null) this.put(old, b);

    return true;
  }

  public Boolean vandalize (String r) {
    if (!this.containsKey(r)) return false;
    this.get(r).setBroken(true);
    return true;
  }
}

/* put
 * get
 * remove
 * replace
 */
