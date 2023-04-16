package jsoft.ads.section;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;
import org.javatuples.*;

public class SectionControl {

	private SectionModel sm;

	public SectionControl(ConnectionPool cp) {
		this.sm = new SectionModel(cp);
	}

	protected void finallize() throws Throwable {
		this.sm = null;
	}

	// **************************************************************************
	public boolean addSection(SectionObject item) {
		return this.sm.addSection(item);
	}

	public boolean editSection(SectionObject item) {
		return this.sm.editSection(item);
	}

	public boolean delSection(SectionObject item) {
		return this.sm.delSection(item);
	}
	// ***************************************************************************

	
	
	// ***************************************************************************

	public SectionObject getSectionObject(short id) {
		return this.sm.getSectionObject(id);
	}

	// ***************************************************************************

	
	
	public Pair<String, String> viewSections(Triplet<SectionObject, Short, Byte> infos) {
		ArrayList<SectionObject> items = this.sm.getSectionObjects(infos.getValue0(), infos.getValue1(),
				infos.getValue2());

		return SectionLibrary.viewSections(items);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();

		SectionControl sc = new SectionControl(cp);

		Triplet<SectionObject, Short, Byte> infos = new Triplet<>(null, (short) 1, (byte) 15);

		Pair<String, String> view = sc.viewSections(infos);

		System.out.println(view.getValue0());
	}
}
