import java.util.HashMap;

/* put
 * get
 * remove
 * replace

if both keys didn't have to be searchable, this could simply be:

class MeterArchine extends HashMap<String, Meter> {}
*/

class MeterArchine {

  // Use hashmaps for O(1) lookup
  private HashMap<String, Meter> posMap = new HashMap<String, Meter> ();
  private HashMap<String, Meter> regMap = new HashMap<String, Meter> ();

  public void put (Meter m) {
    posMap.put(m.getPos(), m);
    regMap.put(m.getReg(), m);
  }

  public Meter getByPos (String pos) { return posMap.get(pos); }
  public Meter getByReg (String reg) { return regMap.get(reg); }

  public void removeByPos (String pos) {
    Meter m = getByPos(pos);
    posMap.remove(pos);
    regMap.remove(m.getReg());
  }
  public void removeByReg (String reg) {
    Meter m = getByReg(reg);
    regMap.remove(reg);
    posMap.remove(m.getPos());
  }

  public void replaceByPos (String pos, Meter x) {
    Meter m = getByPos(pos);
    posMap.replace (pos, x);
    regMap.replace (m.getReg(), x);
  }
  public void replaceByReg (String reg, Meter x) {
    Meter m = getByReg(reg);
    regMap.replace (reg, x);
    posMap.replace (m.getPos(), x);
  }

  // ----------------

  public Boolean move (String reg, String pos) {
    if (!regMap.containsKey(reg)) return false;

    Meter a = regMap.get(reg);
    String aPos = a.getPos();

    posMap.remove(aPos);

    if (posMap.containsKey(pos)) {
      Meter b = posMap.get(pos);
      posMap.remove(pos);
      b.setPos(aPos);
      posMap.put(aPos, b);
    }

    a.setPos(pos);
    posMap.put(pos, a);

    return true;
  }

  public Boolean vandalize (String reg) {
    if (!regMap.containsKey(reg)) return false;
    regMap.get(reg).setBroken(true);
    return true;
  }
}

