public class Task {

        private static int idCounter = 1;
        private int id;
        private String name;
        private boolean completed;

        public Task(String name) {
            this.id = idCounter++;
            this.name = name;
            this.completed = false;
        }

        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public boolean isCompleted() {
            return completed;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        @Override
        public String toString() {
            return id + ". " + name + " (Completed: " + (completed ? "Yes" : "No") + ")";
        }
    }


