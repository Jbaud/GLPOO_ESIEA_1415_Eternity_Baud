
public class Temps {

		private int minutes;
		private int secondes;
		
		public Temps(int minutes, int secondes){
			this.minutes = minutes;
			this.secondes = secondes; 
		}

		public int getMinutes() {
			return minutes;
		}

		public void setMinutes(int minutes) {
			this.minutes = minutes;
		}

		public int getSecondes() {
			return secondes;
		}

		public void setSecondes(int secondes) {
			this.secondes = secondes;
		}

		@Override
		public String toString() {
			return minutes + ":" + secondes;
		}
		




}

