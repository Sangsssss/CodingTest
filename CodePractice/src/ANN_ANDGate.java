
public class ANN_ANDGate {
	
	

	public static void main(String[] args) {
		Perceptron perceptron = new Perceptron();
		int[][] inputs = {{0,0}, {0,1}, {1,0}, {1,1}};
		int[] targets = {0,0,0,1};
		int epochs = 10;
		perceptron.train(inputs, targets, epochs);

	}
}

 class Perceptron {
	double[] weights;
	double rate;
	double threshold;
	

	public Perceptron() {
		this.weights = new double[]{0.3, -0.1};
		this.rate = 0.1;
		this.threshold = 0.2;
	}
	
	public int calWeights(int[] x, double[] weights) {
		double y = (x[0]*weights[0]) + (x[1]*weights[1])-this.threshold;
		if(y>=0)
			return 1;
		else
			return 0;
	}
	public double[] activate(int[] x, double[] weights, int error) {
		for(int i = 0; i<weights.length; i++) {
			weights[i] = Math.round((weights[i] + this.rate * x[i] * error)*10)/10.0;
			
		}
		//0.199999 * 100 = 19.9999 --> 20  --> 20/100 = 0.2
		return weights;
	}
		
		public void train(int[][] inputs, int[] targets, int epochs) {
			System.out.println("Epoch | Inputs | Desired Output | Initial Weights | Output | error | Updated Weights");
			System.out.println("------------------------------------------------------------------------");
			for(int i = 0; i<epochs; i++) {
				int errorCnt = 0;
				for(int k = 0; k<inputs.length; k++) {
					int y = this.calWeights(inputs[k], this.weights);
					//System.out.println(y);
					int error = targets[k] - y;
					if(error != 0)
						errorCnt++;
					double[] currentWeights = this.weights.clone();
					//System.out.println(error);
					this.weights = this.activate(inputs[k], this.weights, error);
					System.out.println(i+1 + "  " + inputs[k][0] + " " + inputs[k][1] + "  " +targets[k] + "  " +currentWeights[0] 
							+ " " + currentWeights[1] + "  " + y + "  " + error + "  " +  this.weights[0] + " " + this.weights[1]);
				}
				
				if(errorCnt == 0)
					break;
				
			}
		
	}
}
