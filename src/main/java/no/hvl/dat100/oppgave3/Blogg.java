package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave2.Bilde;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;
	private static int LENGDE = 20;

	public Blogg() {
		nesteledig = 0;
		innleggtabell = new Innlegg[LENGDE];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int index = -1;
		int i = 0;
		while (i < nesteledig && index < 0) {
			if (innleggtabell[i].erLik(innlegg)) {
				index = 1;
			} else {
				i++;
			}
		}
		return index;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) >= 0;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean lagttil = false;
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			lagttil = true;
		}
		return lagttil;
	}
	
	public String toString() {
		String text = Integer.toString(nesteledig) + "\n";
		for (int i = 0; i < nesteledig; i++) {
			text = text + innleggtabell[i].toString();
		}
		return text;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}