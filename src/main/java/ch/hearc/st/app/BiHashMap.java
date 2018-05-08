package ch.hearc.st.app;


import java.util.HashMap;
import java.util.Map;

public class BiHashMap<K1, K2, V> {

  private final Map<K1, Map<K2, V>> mMap;

  public BiHashMap() {
    mMap = new HashMap<K1, Map<K2, V>>();
  }

  /**
   * Associates the specified value with the specified keys in this map (optional operation). If the map previously
   * contained a mapping for the key, the old value is replaced by the specified value.
   *
   * @param key1
   *            the first key
   * @param key2
   *            the second key
   * @param value
   *            the value to be set
   * @return the value previously associated with (key1,key2), or <code>null</code> if none
   * @see Map#put(Object, Object)
   */
  public V put(K1 key1, K2 key2, V value) {
    Map<K2, V> map;
    if (mMap.containsKey(key1)) {
      map = mMap.get(key1);
    } else {
      map = new HashMap<K2, V>();
      mMap.put(key1, map);
    }

    return map.put(key2, value);
  }

  /**
   * Returns the value to which the specified key is mapped, or <code>null</code> if this map contains no mapping for
   * the key.
   *
   * @param key1
   *            the first key whose associated value is to be returned
   * @param key2
   *            the second key whose associated value is to be returned
   * @return the value to which the specified key is mapped, or <code>null</code> if this map contains no mapping for
   *         the key
   * @see Map#get(Object)
   */
  public V get(K1 key1, K2 key2) {
    if (mMap.containsKey(key1)) {
      return mMap.get(key1).get(key2);
    } else {
      return null;
    }
  }

  /**
   * Returns <code>true</code> if this map contains a mapping for the specified key
   *
   * @param key1
   *            the first key whose presence in this map is to be tested
   * @param key2
   *            the second key whose presence in this map is to be tested
   * @return Returns true if this map contains a mapping for the specified key
   * @see Map#containsKey(Object)
   */
  public boolean containsKeys(K1 key1, K2 key2) {
    return mMap.containsKey(key1) && mMap.get(key1).containsKey(key2);
  }

  public void clear() {
    mMap.clear();
  }

  public void display(){

    for (K1 mapKey1 : mMap.keySet()) {

      for (K2 mapKey2 : mMap.get(mapKey1).keySet()){

        System.out.print(get(mapKey1, mapKey2));

        Integer l = 3-get(mapKey1, mapKey2).toString().length();
        for(int i=0;i<=l;i++){
          System.out.print(" ");
        }

      }

      System.out.println("");
      System.out.println("");

    }
  }

  public Map<K2, V> lineContent(K1 key1){

    Map<K2, V> line = new HashMap<>();

    for (K1 mapKey1 : mMap.keySet()) {

      if(key1.equals(mapKey1)){
        line = mMap.get(mapKey1);
      }

    }

    return line;
  }

  public void displayLine(K1 key1){

    Map<K2, V> line = new HashMap<>();

    line = lineContent(key1);

    for (K2 mapKey2 : line.keySet()){
      System.out.println(line.get(mapKey2));
    }

  }

  public Map<K1, V> columnContent(K2 key2){

    Map<K1, V> column = new HashMap<>();

    for (K1 mapKey1 : mMap.keySet()) {

      for (K2 mapKey2 : mMap.get(mapKey1).keySet()){

        if(key2.equals(mapKey2)){
          column.put(mapKey1, get(mapKey1,mapKey2));
        }

      }
    }
    return column;
  }

  public void displayColumn(K2 key2){

    Map<K1, V> column = new HashMap<>();

    column = columnContent(key2);

    for (K1 mapKey1 : column.keySet()){
      System.out.println(column.get(mapKey1));
    }

  }


  public void transpose(){

    //BiHashMap temporaire
    BiHashMap<K1, K2, V> newMap = new BiHashMap<>();

    //copie des valeurs transposées dans la BiHashMap temporaire
    for (K1 mapKey1 : mMap.keySet()) {
      for (K2 mapKey2 : mMap.get(mapKey1).keySet()){
        newMap.put((K1) mapKey2, (K2) mapKey1, get(mapKey1, mapKey2));
      }
    }

    clear();

    //copie des valeurs dans la BiHashMap
    for (K1 mapKey1 : newMap.mMap.keySet()) {
      for (K2 mapKey2 : newMap.mMap.get(mapKey1).keySet()){
        put((K1) mapKey1, (K2) mapKey2, newMap.get(mapKey1, mapKey2));
      }
    }




  }

}