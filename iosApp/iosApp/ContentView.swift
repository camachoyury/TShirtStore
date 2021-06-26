import SwiftUI
import shared

struct ContentView: View {
    let getShirtList = Injector.init().getShirtList
    @State var greet = "Loading..."
    func load(){
        getShirtList.getCategory(string: "ts_10_13058b") { shirt in
            print(shirt)
            self.greet = shirt.description()
        } failure: { (error) in
            greet = "Error: \(error)"
        }
    }

	var body: some View {
        

        Text(greet).onAppear(){
            load()
        }
		
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
