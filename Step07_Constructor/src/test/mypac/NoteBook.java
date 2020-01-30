package test.mypac;

public class NoteBook {
	// 필드
	private Cpu cpu;
	private Memory memory;
	private HardDisk harddisk;
	
	//생성자
	public NoteBook(Cpu cpu, Memory memory, HardDisk harddisk) {
		this.cpu=cpu;
		this.memory=memory;
		this.harddisk=harddisk;
	}
}
