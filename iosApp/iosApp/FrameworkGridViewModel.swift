//
//  FrameworkGridViewModel.swift
//  iosApp
//
//  Created by Alvaro Mendoza on 4/7/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

final class FrameworkGridViewModel: ObservableObject {

    var selectedShirt: Shirt? {
        didSet {
            isShowingDetailView = true
        }
    }
    @Published var isShowingDetailView = false

}
