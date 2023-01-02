package proje3;

public class Tree
{
	private TreeNode root;
	
	public Tree(){ 
		root = null; 
	}
	public TreeNode getRoot(){
		return root; 
	}
	
	public void preOrderKelime(TreeNode localRoot) {
		if(localRoot!=null){	
			String[] kelimeler = null;
			for(int i = 0; i< localRoot.data.getCumleler().size();i++) {
				kelimeler = localRoot.data.getCumleler().get(i).split(" ");
				System.out.print(kelimeler.length);
				System.out.println();
				for(int j = 0; j< kelimeler.length ; j ++) {	
					insertKelime(kelimeler[j]);
					System.out.print(kelimeler[j]+" ");
				}
				kelimeler = null;
			}
			preOrderKelime(localRoot.leftChild);
			preOrderKelime(localRoot.rightChild);
		}
	}
	
	public void insertKelime(String kelime){
		TreeNode newNode = new TreeNode();
		newNode.kelimedata = kelime;
		if(root==null) {
			root = newNode;
		}
		else{
			TreeNode current = root;
			TreeNode parent;
			while(true){
				parent = current;
				if(kelime.compareTo(current.kelimedata) < 0){
					current = current.leftChild;
					if(current==null){
						parent.leftChild=newNode;
						return;
					}
				} 
				else{
					current = current.rightChild;
					if(current==null){
						parent.rightChild=newNode;
						return;
					}
				}
			}
		} // end else not root
	} // end insert()

	
	
	// A�ac�n preOrder Dola��lmas�
	public void preOrder(TreeNode localRoot){
		if(localRoot!=null){
			localRoot.displayNode();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		
		}
	}

	public int[] maxDepthAndNumNodes(TreeNode root) {
        int[] result = new int[3];
        if (root == null) {
            return result;
        }

        int leftResult[] = maxDepthAndNumNodes(root.leftChild);
        int rightResult[] = maxDepthAndNumNodes(root.rightChild);

        result[0] = Math.max(leftResult[0], rightResult[0]) + 1;
        result[1] = leftResult[1] + rightResult[1] + 1;
        Double dengeli = Math.log(result[1]) / Math.log(2);
        result[2] = dengeli.intValue()+1;

        return result;
    }
      

	// A�aca bir d���m eklemeyi sa�layan metot
	public void insert(milliPark newpark){
		TreeNode newNode = new TreeNode();
		newNode.data = newpark;
		if(root==null) {
			root = newNode;
		}
		else{
			TreeNode current = root;
			TreeNode parent;
			while(true){
				parent = current;
				if(newpark.getMilliPark_Adi().compareTo(current.data.getMilliPark_Adi()) < 0){
					current = current.leftChild;
					if(current==null){
						parent.leftChild=newNode;
						return;
					}
				} 
				else{
					current = current.rightChild;
					if(current==null){
						parent.rightChild=newNode;
						return;
					}
				}
			}
		} // end else not root
	} // end insert()
	
	public TreeNode findNode(TreeNode root, String prefix) {
        if (root == null || prefix == null || prefix.length() < 3) {
            return null;
        }

        int comparison = prefix.compareTo(root.data.milliPark_Adi.substring(0, 3));
        if (comparison == 0) {
            return root;
        } else if (comparison < 0) {
            return findNode(root.leftChild, prefix);
        } else {
            return findNode(root.rightChild, prefix);
        }
    }
} // class Tree
