class problem006 {
	public static void main(String[] args) {
		String arg0 = args[0];
		Integer max = Integer.parseInt(arg0);
		// (a+b)^2 = a^2 + 2ab + b^2
		// (a+b)^2 = (a+b)(a+b) = a(a+b) + b(a+b) = a^2 + ab + ab + b^2 = a^2 + ab + b^2
		// (a+b+c)^2 = (a+b+c)(a+b+c) = a(a+b+c) + b(a+b+c) + c(a+b+c) = a^2+ab+ac+ab+b^2+bc+ac+bc+c^2
		// ... = a^2 + 2ab + 2ac + 2bc + b^2 + c^2
		// (a+b+c+d)^2 = a(a+b+c+d)+b(a+b+c+d)+c(a+b+c+d)+d(a+b+c+d)
		// ... = a^2 + b^2 + c^2 + d^2 + 2ab + 2ac + 2ad + 2bc + 2bd + 2cd
		// ... = (subtracted squares out) + 2(ab + ac + ad + bc + bd + cd)
		int diff = 0;
		for (int i = 1; i <= max; i++) {
			for (int j = i + 1; j <= max; j++) {
				diff += i * j;
			}
		}
		System.out.println(2 * diff);
	}
}