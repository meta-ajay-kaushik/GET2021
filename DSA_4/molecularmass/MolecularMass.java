package molecularmass;
import java.util.*;
// Main Java class MolecularMass
public class MolecularMass {
	Map<Character, Integer> elements = new HashMap<Character, Integer>();
	// constructor
	public MolecularMass() {
		elements.put('H', 1);
		elements.put('C', 12);
		elements.put('O', 16);
	}
	// method to calculate molecular mass
	public int calculateMolecularMass(String molecule) {
		int massOfMolecule = 0;
		String block = "";
		
		for (int index = 0; index < molecule.length(); index++) {
			char character = molecule.charAt(index);
			
			if (character != '(') {
				if (character == 'H' || character == 'C' || character == 'O') {
					if (molecule.charAt(index + 1) >= 50 && molecule.charAt(index + 1) <= 57) {
						massOfMolecule = massOfMolecule + (elements.get(character) * (molecule.charAt(index + 1) - 48));
						index++;
					} else {
						massOfMolecule = massOfMolecule + elements.get(character);
					}
				}
			}
			
			else if (character == '(') {
				while (molecule.charAt(index) != ')' && index < molecule.length()) {
					index++;
					block = block + molecule.charAt(index);
				} 
				index++;
				if (molecule.charAt(index) >= 50 && molecule.charAt(index) <= 57) {
					massOfMolecule = massOfMolecule + (calculateMassOfBlock(block) * (molecule.charAt(index) - 48));
					index++;
				} else {
					massOfMolecule = massOfMolecule + calculateMassOfBlock(block);
				}
			}
		}
		
		return massOfMolecule;
	}
	// method to calculate molecular mass of a block
	private int calculateMassOfBlock(String block) {
		int sumOfBlock = 0;
		
		for (int index = 0; index < block.length(); index++) {
			
			if(block.charAt(index) == 'H' || block.charAt(index) == 'C' || block.charAt(index) == 'O') {
			
				if (block.charAt(index + 1) >= 50 && block.charAt(index + 1) <= 57) {
					sumOfBlock = sumOfBlock + elements.get(block.charAt(index)) * (block.charAt(index + 1) - 48);
				} else {
					sumOfBlock = sumOfBlock + elements.get(block.charAt(index));
				}
			}
		}
		return sumOfBlock;
	}
	// main method
	public static void main(String []args)
	{
		MolecularMass molecularWeight=new MolecularMass();
		String compound="CO2(CH3)2";
//		String compound="C2H2O4";
//		String compound="(COOH)2";
//		String compound="C(OH)2";
		int weight=molecularWeight.calculateMolecularMass(compound);
		System.out.println("weight of "+compound +" is = "+weight);
	}
}