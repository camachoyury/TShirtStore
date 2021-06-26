import SwiftUI
import shared

struct ContentView: View {
    let getShirtList = Injector.init().getShirtList
    
    @State var greet = "Loading..."
    @State var shirts = [Shirt]()
    
    func load(){
        getShirtList.getCategoriesList { (shirtsList) in
            self.shirts = shirtsList
        } failure: { (error) in
            print(error)
        }

    }

	var body: some View {
        
        NavigationView {
                    //3.
                    List(shirts, id: \.self) { shirt in
                    
                        VStack(alignment: .leading) {
                            Image(shirt.image).resizable().scaledToFit()
                            Text(shirt.title)
                                .font(.title)
                                .fontWeight(.bold)
                            Text(String(shirt.price))
                                .font(.subheadline)
                                .fontWeight(.bold)

                        }
                    }
                    //2.
                    .onAppear() {
                       load()
                    }.navigationTitle("TShirt Cool Store")
                }

		
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
