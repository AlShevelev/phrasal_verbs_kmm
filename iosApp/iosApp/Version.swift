//
//  Version.swift
//  iosApp
//
//  Created by Aleksandr Shevelev on 05.07.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

extension Bundle {
    var code: String {
        return String(describing: Bundle.main.infoDictionary?["CFBundleShortVersionString"] ?? "")
    }
    
    var build: String {
        return String(describing: Bundle.main.infoDictionary?["CFBundleVersion"] ?? "")
    }
}
