public class Player<P,S>{
    private ListElement first;

    public class ListElement {
        private P player;
        private S score;
        private ListElement next;
    
        /**
         * Constructor ListElement
         * Set next = null
         */
        public ListElement(P player, S score) {
          this.player = player;
          this.score = score;
          next = null;
        }
    
        /**
         * HINTED METHOD (Boleh dihilangkan jika tidak digunakan)
         * Menghitung panjang rantai ListElement yang ada (terhitung dari elemen *ini*)
         * Mungkin diperlukan untuk menghitung size()
         */
        private int length() {
          if (this.next == null){
            return 1;
          } else {
            return 1 + this.next.length();
          }
        }
        private ListElement getLast() {
            if (this.next == null){
              return this;
            } else {
              return this.next.getLast();
            }
        }
        public P getPlayer(){
            return player;
        }
        public S getScore(){
            return score;
        }
    }
    public Player() {
      first = null;
    }
    public void add(P player, S score) {
      if (size() == 0){
        ListElement firstDump = new ListElement(player, score);
        first = firstDump;
      } else {
        ListElement firstDump2 = first;
        while(first != null){
          if(first.player.equals(player)){
            first.score = score;
          } else {
            first = first.next;
          }
        }
        if (first == null){
          firstDump2.getLast().next = new ListElement(player, score);
        }
  
        first = firstDump2;
      }
    }
    public S get(P player) {
      ListElement tempL;
      ListElement firstStat = first;
      S tempS = null;
      if (firstStat == null){
        return null;
      }else if (first == null){
        return null;
      } else if (first.player.equals(player)){
         return first.score;
      } else {
        tempL = first;
        first = first.next;
        tempS = get(player);
        first = tempL;
        return tempS;
      }
    }
    public int size() {
      if (first == null){
        return 0;
      } else {
        return first.length();
      }
    }public void printInfo(){
        while(first != null){
            System.out.println(first.player + " - " + first.score);
            first = first.next;
        }
    }
}