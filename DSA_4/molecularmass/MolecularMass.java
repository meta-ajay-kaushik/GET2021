package molecularmass;
// Main Java class MolecularMass
public class MolecularMass {
	// method to get atomic weight of atoms
	public int getAtomicWeight(Character atom)
	{
		int atomicWeight=-1;
		if(atom=='C')
		{
			atomicWeight=12;
		}
		else if(atom=='H')
		{
			atomicWeight=1;
		}
		else if(atom=='O')
		{
			atomicWeight=16;
		}
		else if(atom=='(')
		{
			atomicWeight=-2;
		}
		return atomicWeight;
	}
	// method to find multiplier
	public int[] findMultiplier(String compound,int index)
	{
		String str=""+compound.charAt(index);
		int arr[]=new int[2];
		arr[0]=1;
		for(int i=index+1;i<compound.length();i++)
		{
			if(this.getAtomicWeight(compound.charAt(i))==-1)
			{
				arr[0]=arr[0]+1;
				str=str+compound.charAt(i);
			}
			else
			{
				break;
			}
		}
		arr[1]=Integer.parseInt(str);
		return arr;
	}
	// method to calculate molecular weight of the compound
	public int getMolecularWeight(String compound)
	{
		int totalWeight=0;
		for(int i=0;i<compound.length();i++)
		{
			int atomicWeight=this.getAtomicWeight(compound.charAt(i));
			int multiplier=1;
			if(atomicWeight==-2)
			{
				int find=-1;
				for(int j=i+1;j<compound.length();j++)
				{
					if(compound.charAt(j)==')')
					{
						find=j;
						break;
					}
				}
				if(find==-1)
				{
					return find;
				}
				else
				{
					int wght=this.getMolecularWeight(compound.substring(i+1,find));
					i=find;
					if(i<compound.length())
					{
					if(this.getAtomicWeight(compound.charAt(find+1))==-1)
					{
						wght=wght*Integer.parseInt(Character.toString(compound.charAt(find+1)));
						i=i+1;
					}
					}
					totalWeight=totalWeight+wght;
				}
			}
			else if(atomicWeight!=-1)
			{
				if(i!=compound.length()-1)
				{
					int nextatomicWeight=this.getAtomicWeight(compound.charAt(i+1));
					if(nextatomicWeight==-1)
					{
						int arr[]=this.findMultiplier(compound,i+1);
						multiplier=arr[1];
						i=i+arr[0];
					}
				}
			}
			 if(atomicWeight==1)
			{
				totalWeight=totalWeight+multiplier;
			}
			else if(atomicWeight==12)
			{
				totalWeight=totalWeight+multiplier*12;
			}
			else if(atomicWeight==16)
			{
				totalWeight=totalWeight+multiplier*16;
			}		
		}
		return totalWeight;
	}
	// main method
	public static void main(String []args)
	{
		MolecularMass molecularWeight=new MolecularMass();
//		String compound="CH3(CH3)2H2O";
		String compound="C(OH)2";
		int weight=molecularWeight.getMolecularWeight(compound);
		System.out.println("weight of "+compound +" is = "+weight);
	}
}