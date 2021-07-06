import SwiftUI
import shared

struct ContentView: View {
    let getShirtList = Injector.init().getShirtList
    
    @State var greet = "Loading..."
    @State var shirts = [Shirt]()
    @StateObject var viewModel = FrameworkGridViewModel()
    var columns: [GridItem] = [GridItem(.flexible()),GridItem(.flexible()),GridItem(.flexible())]
    
    func load(){
        getShirtList.getCategoriesList { (shirtsList) in
            self.shirts = shirtsList
        } failure: { (error) in
            print(error ?? "")
        }

    }

	var body: some View {

        NavigationView {
            ScrollView {
                LazyVGrid(columns: columns) {
                    ForEach(shirts, id: \.self) { shirt in
                         ShirtTitleView(shirt: shirt)
                            .onTapGesture {
                                viewModel.selectedShirt = shirt
                         }
                    }
                    }

                }.navigationTitle("TShirt Cool Store")
            }
            .sheet(isPresented: $viewModel.isShowingDetailView) {
                FrameworkDetailView(shirt: viewModel.selectedShirt!,
                                    isShowingDetailView: $viewModel.isShowingDetailView)
            }.onAppear() {
                 load()
            }
    }
}
struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	 ContentView()
	}
}

struct ShirtTitleView: View {
    let shirt: Shirt

    var body: some View {
        VStack {
            Image(shirt.image)
                .resizable()
                .frame(width: 90, height: 90)
            Text(shirt.title)
                .font(.title2)
                .fontWeight(.semibold)
                .scaledToFit()
                .minimumScaleFactor(0.6)
                .fixedSize(horizontal: false, vertical: true)
            Text(String(shirt.price))
                .font(.subheadline)
                .fontWeight(.bold)
        }.padding()
    }
}
