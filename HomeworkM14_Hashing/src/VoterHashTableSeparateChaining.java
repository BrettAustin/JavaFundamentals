
public class VoterHashTableSeparateChaining {

	public Node<Voter>[] hashTable; // made public for testing purposes only!
	public int tableSize; 		     // made public for testing purposes only!

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}
	
	public int getHashTableLocation(int voterID) {
		return voterID%tableSize;
	}

	public boolean addVoter(Voter voterToAdd) {
		int hashLocation = getHashTableLocation(voterToAdd.getId());
		Node newNode = new Node(voterToAdd);

		if(hashTable[hashLocation]==null){
			hashTable[hashLocation] = newNode;
		}
		else{
			Node currentNode = hashTable[hashLocation];
			while(currentNode.next!=null){
				currentNode=currentNode.next;
			}
			currentNode.next = newNode;
		}
		return true;
	}

	public Voter getVoter(int voterID) {
		int hashLocation = getHashTableLocation(voterID);

		if(hashTable[hashLocation]==null){
			return null;
		}
		if(hashTable[hashLocation].getData().getId()==voterID){
			return hashTable[hashLocation].getData();
		}else{
			Node<Voter> currentNode = new Node(hashTable[hashLocation]);
			System.out.println("This "+currentNode.getData());
			System.out.println("This is next" +currentNode.next);

			while(currentNode.next!=null){
				currentNode=currentNode.next;
				System.out.println("***Next***");
				if(currentNode.getData().getId()==voterID){
					return currentNode.getData();
				}
			}
		}
		return null;
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print("Location " + i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
