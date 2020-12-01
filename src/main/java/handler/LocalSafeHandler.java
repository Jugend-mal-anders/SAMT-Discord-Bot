package handler;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import storage.Container;

public class LocalSafeHandler {

	private LocalSafeHandler() {

	}

	public static void loadData() {

		if (!Container.VotingFile.exists()) {
			try {
				Container.VotingFile.createNewFile();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		} else {
			try (Scanner s = new Scanner(Container.VotingFile)) {
				while (s.hasNextLong()) {
					Container.ActiveVotings.add(s.nextLong());
				}
			} catch (final FileNotFoundException e) {
				e.printStackTrace();
			}

		}
	}

	public static void saveData() {

		try (FileWriter fw = new FileWriter(Container.VotingFile); BufferedWriter bw = new BufferedWriter(fw)) {
			for (Long i : Container.ActiveVotings) {
				bw.write("" + i);
				bw.newLine();
			}
			bw.flush();
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

}
