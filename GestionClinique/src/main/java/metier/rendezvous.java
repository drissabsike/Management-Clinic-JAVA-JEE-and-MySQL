package metier;

public class rendezvous {

		private int id;
		private String cin;
		private String fullname;
		private String description;
		private String date_rdv;
		
		public rendezvous() {
			super();
			// TODO Auto-generated constructor stub
		}

		public rendezvous(String cin, String fullname, String description, String date_rdv) {
			super();
			this.cin = cin;
			this.fullname = fullname;
			this.description = description;
			this.date_rdv = date_rdv;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCin() {
			return cin;
		}

		public void setCin(String cin) {
			this.cin = cin;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDate_rdv() {
			return date_rdv;
		}

		public void setDate_rdv(String date_rdv) {
			this.date_rdv = date_rdv;
		}
		
		
	
}
