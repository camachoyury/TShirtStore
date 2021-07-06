//
//  FrameworkDetailView.swift
//  iosApp
//
//  Created by Alvaro Mendoza on 4/7/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct FrameworkDetailView: View {
    var shirt: Shirt
    @Binding var isShowingDetailView: Bool

    var body: some View {
        VStack {
            HStack {
                Spacer()
                Button {
                    isShowingDetailView = false
                } label: {
                    Image(systemName: "xmark")
                        .foregroundColor(Color(.label))
                        .imageScale(.large)
                        .frame(width: 44, height: 44)
                }
            }
            .padding()

            Spacer()
            ShirtTitleView(shirt: shirt)
            Text(shirt.description)
                .font(.body)
                .padding()
        }
    }
}

