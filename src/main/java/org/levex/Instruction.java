package org.levex;

public class Instruction {

	public static final int INSTRUCTION_MOVE = 1;

	public static final int OPERAND_REGISTER = 1;
	public static final int OPERAND_LITERAL = 2;

	private int ins = 0;

	private int p0 = 0;
	private int p0_type = 0;

	private int p1_type = 0;
	private int p1 = 0;

	public int getFirstParam() {
		return p0;
	}

	public int getSecondParam() {
		return p1;
	}

	public int getFirstParamType() {
		return p0_type;
	}

	public int getSecondParamType() {
		return p1_type;
	}

	public int getInstruction() {
		return ins;	
	}

	public Instruction(String instr) {
		/* parse the instruction */
		String[] array = instr.split(" ");
		/* parse first word */
		if(array[0].equalsIgnoreCase("mov")) {
			ins = INSTRUCTION_MOVE;
		} else {
			ins = 0;		
		}
		/* parse second word ( source ) */
		if(array[1].startsWith("r")) {
			p0_type = OPERAND_REGISTER;
			p0 = Integer.parseInt(array[1].substring(1));
		} else {
			p0_type = OPERAND_LITERAL;		
			p0 = Integer.parseInt(array[1]);
		}

		/* parse third word ( dest ) */
		if(array[2].startsWith("r")) {
			p1_type = OPERAND_REGISTER;
			p1 = Integer.parseInt(array[2].substring(1));
		} else {
			p1_type = OPERAND_LITERAL;		
			p1 = Integer.parseInt(array[2]);
		}
	}

	public void executeInstruction()
	{
		Netocomp.postInstruction(this);
	}
}
