package arvoreAVL;

public class Tree {
    private Sheet root;
   
    private int getHeight(Sheet sheet) {
        if (sheet == null) {
            return 0;
        }
        return sheet.getHeight();
    }
     
    private int getBalanceFactor(Sheet sheet) {
        if (sheet == null) {
            return 0;
        }
        return getHeight(sheet.getLeft()) - getHeight(sheet.getRight());
    }

    private Sheet rotateRight(Sheet y) {
        Sheet x = y.getLeft();
        Sheet temp = x.getRight();

        x.setRight(y);
        y.setLeft(temp);

        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);

        return x;
    }

    private Sheet rotateLeft(Sheet x) {
        Sheet y = x.getRight();
        Sheet temp = y.getLeft();

        y.setLeft(x);
        x.setRight(temp);

        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

        return y;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Sheet insert(Sheet sheet, int value) {
        if (sheet == null) {
            return new Sheet(value);
        }

        if (value < sheet.getValue()) {
            sheet.setLeft(insert(sheet.getLeft(), value));
        } else if (value > sheet.getValue()) {
            sheet.setRight(insert(sheet.getRight(), value));
        } else {
            return sheet;
        }

        sheet.setHeight(1 + Math.max(getHeight(sheet.getLeft()), getHeight(sheet.getRight())));
        int balance = getBalanceFactor(sheet);

        // Caso 1: Left-Left
        if (balance > 1 && value < sheet.getLeft().getValue())
            return rotateRight(sheet);

        // Caso 2: Right-Right
        if (balance < -1 && value > sheet.getRight().getValue())
            return rotateLeft(sheet);

        // Caso 3: Left-Right
        if (balance > 1 && value > sheet.getLeft().getValue()) {
            sheet.setLeft(rotateLeft(sheet.getLeft()));
            return rotateRight(sheet);
        }

        // Caso 4: Right-Left
        if (balance < -1 && value < sheet.getRight().getValue()) {
            sheet.setRight(rotateRight(sheet.getRight()));
            return rotateLeft(sheet);
        }

        return sheet;
    }

    public String printInOrder() {
        StringBuilder sb = new StringBuilder();
        buildInOrderString(root, sb);
        return sb.toString().trim();
    }

    private void buildInOrderString(Sheet sheet, StringBuilder sb) {
        if (sheet != null) {
            buildInOrderString(sheet.getLeft(), sb);
            sb.append(sheet.getValue()).append(" ");
            buildInOrderString(sheet.getRight(), sb);
        }
    }
    
   public Sheet search(int value){
      return searchRecursive(value, this.root);
   }
   
   public Sheet searchRecursive(int value, Sheet cursor){
      if(cursor == null){
         return null;
      }
      
      if(value == cursor.getValue()){
         return cursor;
      }
      
      if(value < cursor.getValue()){
         return searchRecursive(value, cursor.getLeft());
      } else if(value > cursor.getValue()){
         return searchRecursive(value, cursor.getRight());
      }
      
      return null;
   }
}
