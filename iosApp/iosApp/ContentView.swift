import SwiftUI
import shared

struct ContentView: View {
	let getShirtList = GetShirtList(ShirtRepositoryImpl(Api()))

	var body: some View {

	  getShirtList.getCategoriesList(
                success = {
                    adapter.setShirtList(it)

                },
                failure = ::handleError
            )
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}