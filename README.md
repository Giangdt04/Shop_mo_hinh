
```
Shop_mo_hinh
├─ Back_end
│  ├─ .idea
│  │  ├─ compiler.xml
│  │  ├─ encodings.xml
│  │  ├─ jarRepositories.xml
│  │  ├─ misc.xml
│  │  ├─ vcs.xml
│  │  └─ workspace.xml
│  ├─ Dockerfile
│  ├─ pom.xml
│  ├─ src
│  │  ├─ main
│  │  │  ├─ java
│  │  │  │  └─ com
│  │  │  │     └─ example
│  │  │  │        └─ shopmohinh
│  │  │  │           ├─ configuration
│  │  │  │           │  ├─ ApplicationInitConfig.java
│  │  │  │           │  ├─ CloudinaryConfig.java
│  │  │  │           │  ├─ CustomJwtDecoder.java
│  │  │  │           │  ├─ JwtAuthenticationEntryPoint.java
│  │  │  │           │  ├─ MailConfig.java
│  │  │  │           │  ├─ RedisConfig.java
│  │  │  │           │  ├─ SecurityConfig.java
│  │  │  │           │  ├─ VnpayConfig.java
│  │  │  │           │  └─ WebConfig.java
│  │  │  │           ├─ constant
│  │  │  │           │  ├─ Contant.java
│  │  │  │           │  └─ ProductStatusConstant.java
│  │  │  │           ├─ controller
│  │  │  │           │  ├─ AdminController.java
│  │  │  │           │  ├─ AuthenticationController.java
│  │  │  │           │  ├─ BrandController.java
│  │  │  │           │  ├─ CartDetailController.java
│  │  │  │           │  ├─ CategoryController.java
│  │  │  │           │  ├─ MaterialController.java
│  │  │  │           │  ├─ MomoController.java
│  │  │  │           │  ├─ PaymentController.java
│  │  │  │           │  ├─ PermissionController.java
│  │  │  │           │  ├─ ProductController.java
│  │  │  │           │  ├─ RoleController.java
│  │  │  │           │  ├─ SizeController.java
│  │  │  │           │  └─ UserController.java
│  │  │  │           ├─ dto
│  │  │  │           │  ├─ projection
│  │  │  │           │  │  └─ ProductProjection.java
│  │  │  │           │  ├─ request
│  │  │  │           │  │  ├─ AuthenticationRequest.java
│  │  │  │           │  │  ├─ BrandRequest.java
│  │  │  │           │  │  ├─ CartDetailRequest.java
│  │  │  │           │  │  ├─ CategoryRequest.java
│  │  │  │           │  │  ├─ ImageRequest.java
│  │  │  │           │  │  ├─ IntrospectRequest.java
│  │  │  │           │  │  ├─ LogoutRequest.java
│  │  │  │           │  │  ├─ MaterialRequest.java
│  │  │  │           │  │  ├─ PaymentResquest.java
│  │  │  │           │  │  ├─ PermissionRequest.java
│  │  │  │           │  │  ├─ ProductRequest.java
│  │  │  │           │  │  ├─ RefeshRequest.java
│  │  │  │           │  │  ├─ ResetPasswordRequest.java
│  │  │  │           │  │  ├─ RoleRequest.java
│  │  │  │           │  │  ├─ SizeRequest.java
│  │  │  │           │  │  ├─ UserCreationRequest.java
│  │  │  │           │  │  └─ UserUpdateRequest.java
│  │  │  │           │  ├─ response
│  │  │  │           │  │  ├─ ApiResponse.java
│  │  │  │           │  │  ├─ AuthenticationResponse.java
│  │  │  │           │  │  ├─ BrandResponse.java
│  │  │  │           │  │  ├─ CartDetailResponse.java
│  │  │  │           │  │  ├─ CategoryResponse.java
│  │  │  │           │  │  ├─ ImageResponse.java
│  │  │  │           │  │  ├─ IntrospectResponse.java
│  │  │  │           │  │  ├─ MaterialResponse.java
│  │  │  │           │  │  ├─ PermissionResponse.java
│  │  │  │           │  │  ├─ ProductResponse.java
│  │  │  │           │  │  ├─ RoleResponse.java
│  │  │  │           │  │  ├─ SizeResponse.java
│  │  │  │           │  │  └─ UserResponse.java
│  │  │  │           │  └─ search
│  │  │  │           │     ├─ ProductSearch.java
│  │  │  │           │     └─ SearchDto.java
│  │  │  │           ├─ entity
│  │  │  │           │  ├─ AbtractEntity.java
│  │  │  │           │  ├─ BillDetailEntity.java
│  │  │  │           │  ├─ BillEntity.java
│  │  │  │           │  ├─ BrandEntity.java
│  │  │  │           │  ├─ CartDetailEntity.java
│  │  │  │           │  ├─ CartEntity.java
│  │  │  │           │  ├─ Category.java
│  │  │  │           │  ├─ ImageEntity.java
│  │  │  │           │  ├─ InvalidatedToken.java
│  │  │  │           │  ├─ MaterialEntity.java
│  │  │  │           │  ├─ PasswordResetTokens.java
│  │  │  │           │  ├─ PaymentEntity.java
│  │  │  │           │  ├─ Permission.java
│  │  │  │           │  ├─ Product.java
│  │  │  │           │  ├─ Role.java
│  │  │  │           │  ├─ SizeEntity.java
│  │  │  │           │  └─ User.java
│  │  │  │           ├─ exception
│  │  │  │           │  ├─ AppException.java
│  │  │  │           │  ├─ ErrorCode.java
│  │  │  │           │  └─ GlobalExceptionHandler.java
│  │  │  │           ├─ mapper
│  │  │  │           │  ├─ BrandMapper.java
│  │  │  │           │  ├─ CartDetailMapper.java
│  │  │  │           │  ├─ CategoryMapper.java
│  │  │  │           │  ├─ MaterialMapper.java
│  │  │  │           │  ├─ PermissionMapper.java
│  │  │  │           │  ├─ ProductMapper.java
│  │  │  │           │  ├─ RoleMapper.java
│  │  │  │           │  ├─ SizeMapper.java
│  │  │  │           │  └─ UserMapper.java
│  │  │  │           ├─ repository
│  │  │  │           │  ├─ BrandRepository.java
│  │  │  │           │  ├─ CartDetailRepository.java
│  │  │  │           │  ├─ CartRepository.java
│  │  │  │           │  ├─ CategoryRepository.java
│  │  │  │           │  ├─ ImageRepository.java
│  │  │  │           │  ├─ InvalidatedTokenRepository.java
│  │  │  │           │  ├─ MaterialRepository.java
│  │  │  │           │  ├─ PasswordResetTokensRepository.java
│  │  │  │           │  ├─ PermissionRepository.java
│  │  │  │           │  ├─ ProductRepository.java
│  │  │  │           │  ├─ RoleRepository.java
│  │  │  │           │  ├─ SizeRepository.java
│  │  │  │           │  └─ UserRepository.java
│  │  │  │           ├─ service
│  │  │  │           │  ├─ CartDetailService.java
│  │  │  │           │  └─ impl
│  │  │  │           │     ├─ AuthenticationService.java
│  │  │  │           │     ├─ BrandService.java
│  │  │  │           │     ├─ CartDetailServiceImpl.java
│  │  │  │           │     ├─ CategoryService.java
│  │  │  │           │     ├─ MaterialService.java
│  │  │  │           │     ├─ MomoService.java
│  │  │  │           │     ├─ PasswordResetService.java
│  │  │  │           │     ├─ PermissionService.java
│  │  │  │           │     ├─ ProductService.java
│  │  │  │           │     ├─ RoleService.java
│  │  │  │           │     ├─ SizeService.java
│  │  │  │           │     ├─ UserService.java
│  │  │  │           │     └─ VnpayService.java
│  │  │  │           ├─ ShopmohinhApplication.java
│  │  │  │           └─ util
│  │  │  │              └─ FileUploadUtil.java
│  │  │  └─ resources
│  │  │     └─ application.properties
│  │  └─ test
│  │     └─ java
│  │        └─ com
│  │           └─ example
│  │              └─ shopmohinh
│  │                 └─ ShopmohinhApplicationTests.java
│  └─ target
│     ├─ classes
│     │  ├─ application.properties
│     │  └─ com
│     │     └─ example
│     │        └─ shopmohinh
│     │           ├─ configuration
│     │           │  ├─ ApplicationInitConfig.class
│     │           │  ├─ CloudinaryConfig.class
│     │           │  ├─ CustomJwtDecoder.class
│     │           │  ├─ JwtAuthenticationEntryPoint.class
│     │           │  ├─ MailConfig.class
│     │           │  ├─ RedisConfig.class
│     │           │  ├─ SecurityConfig.class
│     │           │  ├─ VnpayConfig.class
│     │           │  └─ WebConfig.class
│     │           ├─ constant
│     │           │  ├─ Contant.class
│     │           │  └─ ProductStatusConstant.class
│     │           ├─ controller
│     │           │  ├─ AdminController.class
│     │           │  ├─ AuthenticationController.class
│     │           │  ├─ BrandController.class
│     │           │  ├─ CartDetailController.class
│     │           │  ├─ CategoryController.class
│     │           │  ├─ MaterialController.class
│     │           │  ├─ MomoController.class
│     │           │  ├─ PaymentController.class
│     │           │  ├─ PermissionController.class
│     │           │  ├─ ProductController.class
│     │           │  ├─ RoleController.class
│     │           │  ├─ SizeController.class
│     │           │  └─ UserController.class
│     │           ├─ dto
│     │           │  ├─ projection
│     │           │  │  └─ ProductProjection.class
│     │           │  ├─ request
│     │           │  │  ├─ AuthenticationRequest$AuthenticationRequestBuilder.class
│     │           │  │  ├─ AuthenticationRequest.class
│     │           │  │  ├─ BrandRequest$BrandRequestBuilder.class
│     │           │  │  ├─ BrandRequest.class
│     │           │  │  ├─ CartDetailRequest.class
│     │           │  │  ├─ CategoryRequest$CategoryRequestBuilder.class
│     │           │  │  ├─ CategoryRequest.class
│     │           │  │  ├─ ImageRequest.class
│     │           │  │  ├─ IntrospectRequest$IntrospectRequestBuilder.class
│     │           │  │  ├─ IntrospectRequest.class
│     │           │  │  ├─ LogoutRequest$LogoutRequestBuilder.class
│     │           │  │  ├─ LogoutRequest.class
│     │           │  │  ├─ MaterialRequest$MaterialRequestBuilder.class
│     │           │  │  ├─ MaterialRequest.class
│     │           │  │  ├─ PaymentResquest$PaymentResquestBuilder.class
│     │           │  │  ├─ PaymentResquest.class
│     │           │  │  ├─ PermissionRequest$PermissionRequestBuilder.class
│     │           │  │  ├─ PermissionRequest.class
│     │           │  │  ├─ ProductRequest$ProductRequestBuilder.class
│     │           │  │  ├─ ProductRequest.class
│     │           │  │  ├─ RefeshRequest$RefeshRequestBuilder.class
│     │           │  │  ├─ RefeshRequest.class
│     │           │  │  ├─ ResetPasswordRequest$ResetPasswordRequestBuilder.class
│     │           │  │  ├─ ResetPasswordRequest.class
│     │           │  │  ├─ RoleRequest$RoleRequestBuilder.class
│     │           │  │  ├─ RoleRequest.class
│     │           │  │  ├─ SizeRequest$SizeRequestBuilder.class
│     │           │  │  ├─ SizeRequest.class
│     │           │  │  ├─ UserCreationRequest$UserCreationRequestBuilder.class
│     │           │  │  ├─ UserCreationRequest.class
│     │           │  │  ├─ UserUpdateRequest$UserUpdateRequestBuilder.class
│     │           │  │  └─ UserUpdateRequest.class
│     │           │  ├─ response
│     │           │  │  ├─ ApiResponse$ApiResponseBuilder.class
│     │           │  │  ├─ ApiResponse.class
│     │           │  │  ├─ AuthenticationResponse$AuthenticationResponseBuilder.class
│     │           │  │  ├─ AuthenticationResponse.class
│     │           │  │  ├─ BrandResponse$BrandResponseBuilder.class
│     │           │  │  ├─ BrandResponse.class
│     │           │  │  ├─ CartDetailResponse.class
│     │           │  │  ├─ CategoryResponse$CategoryResponseBuilder.class
│     │           │  │  ├─ CategoryResponse.class
│     │           │  │  ├─ ImageResponse$ImageResponseBuilder.class
│     │           │  │  ├─ ImageResponse.class
│     │           │  │  ├─ IntrospectResponse$IntrospectResponseBuilder.class
│     │           │  │  ├─ IntrospectResponse.class
│     │           │  │  ├─ MaterialResponse$MaterialResponseBuilder.class
│     │           │  │  ├─ MaterialResponse.class
│     │           │  │  ├─ PermissionResponse$PermissionResponseBuilder.class
│     │           │  │  ├─ PermissionResponse.class
│     │           │  │  ├─ ProductResponse$ProductResponseBuilder.class
│     │           │  │  ├─ ProductResponse.class
│     │           │  │  ├─ RoleResponse$RoleResponseBuilder.class
│     │           │  │  ├─ RoleResponse.class
│     │           │  │  ├─ SizeResponse$SizeResponseBuilder.class
│     │           │  │  ├─ SizeResponse.class
│     │           │  │  ├─ UserResponse$UserResponseBuilder.class
│     │           │  │  └─ UserResponse.class
│     │           │  └─ search
│     │           │     ├─ ProductSearch.class
│     │           │     └─ SearchDto.class
│     │           ├─ entity
│     │           │  ├─ AbtractEntity.class
│     │           │  ├─ BillDetailEntity$BillDetailEntityBuilder.class
│     │           │  ├─ BillDetailEntity.class
│     │           │  ├─ BillEntity$BillEntityBuilder.class
│     │           │  ├─ BillEntity.class
│     │           │  ├─ BrandEntity$BrandEntityBuilder.class
│     │           │  ├─ BrandEntity.class
│     │           │  ├─ CartDetailEntity$CartDetailEntityBuilder.class
│     │           │  ├─ CartDetailEntity.class
│     │           │  ├─ CartEntity$CartEntityBuilder.class
│     │           │  ├─ CartEntity.class
│     │           │  ├─ Category$CategoryBuilder.class
│     │           │  ├─ Category.class
│     │           │  ├─ ImageEntity$ImageEntityBuilder.class
│     │           │  ├─ ImageEntity.class
│     │           │  ├─ InvalidatedToken$InvalidatedTokenBuilder.class
│     │           │  ├─ InvalidatedToken.class
│     │           │  ├─ MaterialEntity$MaterialEntityBuilder.class
│     │           │  ├─ MaterialEntity.class
│     │           │  ├─ PasswordResetTokens$PasswordResetTokensBuilder.class
│     │           │  ├─ PasswordResetTokens.class
│     │           │  ├─ PaymentEntity$PaymentEntityBuilder.class
│     │           │  ├─ PaymentEntity.class
│     │           │  ├─ Permission$PermissionBuilder.class
│     │           │  ├─ Permission.class
│     │           │  ├─ Product$ProductBuilder.class
│     │           │  ├─ Product.class
│     │           │  ├─ Role$RoleBuilder.class
│     │           │  ├─ Role.class
│     │           │  ├─ SizeEntity$SizeEntityBuilder.class
│     │           │  ├─ SizeEntity.class
│     │           │  ├─ User$UserBuilder.class
│     │           │  └─ User.class
│     │           ├─ exception
│     │           │  ├─ AppException.class
│     │           │  ├─ ErrorCode.class
│     │           │  └─ GlobalExceptionHandler.class
│     │           ├─ mapper
│     │           │  ├─ BrandMapper.class
│     │           │  ├─ BrandMapperImpl.class
│     │           │  ├─ CartDetailMapper.class
│     │           │  ├─ CartDetailMapperImpl.class
│     │           │  ├─ CategoryMapper.class
│     │           │  ├─ CategoryMapperImpl.class
│     │           │  ├─ MaterialMapper.class
│     │           │  ├─ MaterialMapperImpl.class
│     │           │  ├─ PermissionMapper.class
│     │           │  ├─ PermissionMapperImpl.class
│     │           │  ├─ ProductMapper.class
│     │           │  ├─ ProductMapperImpl.class
│     │           │  ├─ RoleMapper.class
│     │           │  ├─ RoleMapperImpl.class
│     │           │  ├─ SizeMapper.class
│     │           │  ├─ SizeMapperImpl.class
│     │           │  ├─ UserMapper.class
│     │           │  └─ UserMapperImpl.class
│     │           ├─ repository
│     │           │  ├─ BrandRepository.class
│     │           │  ├─ CartDetailRepository.class
│     │           │  ├─ CartRepository.class
│     │           │  ├─ CategoryRepository.class
│     │           │  ├─ ImageRepository.class
│     │           │  ├─ InvalidatedTokenRepository.class
│     │           │  ├─ MaterialRepository.class
│     │           │  ├─ PasswordResetTokensRepository.class
│     │           │  ├─ PermissionRepository.class
│     │           │  ├─ ProductRepository.class
│     │           │  ├─ RoleRepository.class
│     │           │  ├─ SizeRepository.class
│     │           │  └─ UserRepository.class
│     │           ├─ service
│     │           │  ├─ CartDetailService.class
│     │           │  └─ impl
│     │           │     ├─ AuthenticationService.class
│     │           │     ├─ BrandService.class
│     │           │     ├─ CartDetailServiceImpl.class
│     │           │     ├─ CategoryService.class
│     │           │     ├─ MaterialService.class
│     │           │     ├─ MomoService.class
│     │           │     ├─ PasswordResetService.class
│     │           │     ├─ PermissionService.class
│     │           │     ├─ ProductService.class
│     │           │     ├─ RoleService.class
│     │           │     ├─ SizeService.class
│     │           │     ├─ UserService.class
│     │           │     └─ VnpayService.class
│     │           ├─ ShopmohinhApplication.class
│     │           └─ util
│     │              └─ FileUploadUtil.class
│     ├─ generated-sources
│     │  └─ annotations
│     │     └─ com
│     │        └─ example
│     │           └─ shopmohinh
│     │              └─ mapper
│     │                 ├─ BrandMapperImpl.java
│     │                 ├─ CartDetailMapperImpl.java
│     │                 ├─ CategoryMapperImpl.java
│     │                 ├─ MaterialMapperImpl.java
│     │                 ├─ PermissionMapperImpl.java
│     │                 ├─ ProductMapperImpl.java
│     │                 ├─ RoleMapperImpl.java
│     │                 ├─ SizeMapperImpl.java
│     │                 └─ UserMapperImpl.java
│     ├─ generated-test-sources
│     │  └─ test-annotations
│     └─ test-classes
│        └─ com
│           └─ example
│              └─ shopmohinh
│                 └─ ShopmohinhApplicationTests.class
├─ docker-compose.yml
└─ Front_end
   ├─ .angular
   │  └─ cache
   │     └─ 19.1.6
   │        └─ angular-basic-project
   │           ├─ .tsbuildinfo
   │           └─ vite
   │              ├─ deps
   │              │  ├─ @angular_common.js
   │              │  ├─ @angular_common.js.map
   │              │  ├─ @angular_common_http.js
   │              │  ├─ @angular_common_http.js.map
   │              │  ├─ @angular_core.js
   │              │  ├─ @angular_core.js.map
   │              │  ├─ @angular_core_rxjs-interop.js
   │              │  ├─ @angular_core_rxjs-interop.js.map
   │              │  ├─ @angular_forms.js
   │              │  ├─ @angular_forms.js.map
   │              │  ├─ @angular_platform-browser.js
   │              │  ├─ @angular_platform-browser.js.map
   │              │  ├─ @angular_router.js
   │              │  ├─ @angular_router.js.map
   │              │  ├─ chunk-2IAKBV5C.js
   │              │  ├─ chunk-2IAKBV5C.js.map
   │              │  ├─ chunk-5TID76VL.js
   │              │  ├─ chunk-5TID76VL.js.map
   │              │  ├─ chunk-KOO6HHSS.js
   │              │  ├─ chunk-KOO6HHSS.js.map
   │              │  ├─ chunk-VU6X2Q5G.js
   │              │  ├─ chunk-VU6X2Q5G.js.map
   │              │  ├─ chunk-X5PQU444.js
   │              │  ├─ chunk-X5PQU444.js.map
   │              │  ├─ package.json
   │              │  ├─ rxjs.js
   │              │  ├─ rxjs.js.map
   │              │  └─ _metadata.json
   │              └─ deps_ssr
   │                 ├─ @angular_common.js
   │                 ├─ @angular_common.js.map
   │                 ├─ @angular_common_http.js
   │                 ├─ @angular_common_http.js.map
   │                 ├─ @angular_core.js
   │                 ├─ @angular_core.js.map
   │                 ├─ @angular_core_rxjs-interop.js
   │                 ├─ @angular_core_rxjs-interop.js.map
   │                 ├─ @angular_forms.js
   │                 ├─ @angular_forms.js.map
   │                 ├─ @angular_platform-browser.js
   │                 ├─ @angular_platform-browser.js.map
   │                 ├─ @angular_platform-server.js
   │                 ├─ @angular_platform-server.js.map
   │                 ├─ @angular_router.js
   │                 ├─ @angular_router.js.map
   │                 ├─ @angular_ssr.js
   │                 ├─ @angular_ssr.js.map
   │                 ├─ @angular_ssr_node.js
   │                 ├─ @angular_ssr_node.js.map
   │                 ├─ chunk-2J4BYE4I.js
   │                 ├─ chunk-2J4BYE4I.js.map
   │                 ├─ chunk-AT7LWMXR.js
   │                 ├─ chunk-AT7LWMXR.js.map
   │                 ├─ chunk-CWVPAAV7.js
   │                 ├─ chunk-CWVPAAV7.js.map
   │                 ├─ chunk-Q2YBGYWZ.js
   │                 ├─ chunk-Q2YBGYWZ.js.map
   │                 ├─ chunk-T4XHMJL2.js
   │                 ├─ chunk-T4XHMJL2.js.map
   │                 ├─ chunk-YHCV7DAQ.js
   │                 ├─ chunk-YHCV7DAQ.js.map
   │                 ├─ chunk-ZE37V5XJ.js
   │                 ├─ chunk-ZE37V5XJ.js.map
   │                 ├─ chunk-ZRSGASEU.js
   │                 ├─ chunk-ZRSGASEU.js.map
   │                 ├─ chunk-ZY5P5JLT.js
   │                 ├─ chunk-ZY5P5JLT.js.map
   │                 ├─ express.js
   │                 ├─ express.js.map
   │                 ├─ package.json
   │                 ├─ rxjs.js
   │                 ├─ rxjs.js.map
   │                 ├─ xhr2-TXIMV6CV.js
   │                 ├─ xhr2-TXIMV6CV.js.map
   │                 └─ _metadata.json
   ├─ .editorconfig
   ├─ angular.json
   ├─ Dockerfile
   ├─ package-lock.json
   ├─ package.json
   ├─ public
   │  └─ favicon.ico
   ├─ README.md
   ├─ src
   │  ├─ app
   │  │  ├─ app.component.css
   │  │  ├─ app.component.html
   │  │  ├─ app.component.ts
   │  │  ├─ app.config.server.ts
   │  │  ├─ app.config.ts
   │  │  ├─ app.routes.server.ts
   │  │  ├─ app.routes.ts
   │  │  ├─ cart
   │  │  │  ├─ cart.component.css
   │  │  │  ├─ cart.component.html
   │  │  │  ├─ cart.component.spec.ts
   │  │  │  └─ cart.component.ts
   │  │  ├─ checkout
   │  │  │  ├─ checkout.component.css
   │  │  │  ├─ checkout.component.html
   │  │  │  ├─ checkout.component.spec.ts
   │  │  │  └─ checkout.component.ts
   │  │  ├─ create
   │  │  │  ├─ create.component.css
   │  │  │  ├─ create.component.html
   │  │  │  └─ create.component.ts
   │  │  ├─ detail
   │  │  │  ├─ detail.component.css
   │  │  │  ├─ detail.component.html
   │  │  │  └─ detail.component.ts
   │  │  ├─ header-layout
   │  │  │  ├─ header-layout.component.css
   │  │  │  ├─ header-layout.component.html
   │  │  │  ├─ header-layout.component.ts
   │  │  │  └─ pipes
   │  │  │     ├─ CurrencyPipe.ts
   │  │  │     └─ UppercasePipe.ts
   │  │  ├─ home
   │  │  │  ├─ home.component.css
   │  │  │  ├─ home.component.html
   │  │  │  └─ home.component.ts
   │  │  ├─ interceptor
   │  │  │  └─ custom.interceptor.ts
   │  │  ├─ login
   │  │  │  ├─ login.component.css
   │  │  │  ├─ login.component.html
   │  │  │  ├─ login.component.spec.ts
   │  │  │  └─ login.component.ts
   │  │  ├─ momo-return
   │  │  │  └─ momo-return.component.ts
   │  │  ├─ payment-result
   │  │  │  ├─ payment-result.component.css
   │  │  │  ├─ payment-result.component.html
   │  │  │  ├─ payment-result.component.spec.ts
   │  │  │  └─ payment-result.component.ts
   │  │  ├─ product-item
   │  │  │  ├─ productItem.component.css
   │  │  │  ├─ productItem.component.html
   │  │  │  └─ productItem.component.ts
   │  │  ├─ register
   │  │  │  ├─ register.component.css
   │  │  │  ├─ register.component.html
   │  │  │  ├─ register.component.spec.ts
   │  │  │  └─ register.component.ts
   │  │  ├─ shared
   │  │  │  └─ notification
   │  │  │     ├─ notification.component.css
   │  │  │     ├─ notification.component.html
   │  │  │     └─ notification.component.ts
   │  │  ├─ types
   │  │  │  ├─ productItem.ts
   │  │  │  └─ responseData.ts
   │  │  └─ vnpay-return
   │  │     └─ vnpay-return.component.ts
   │  ├─ assets
   │  │  ├─ data
   │  │  │  ├─ full_json_generated_data_vn_units.json
   │  │  │  ├─ simplified_json_generated_data_vn_units.json
   │  │  │  ├─ simplified_json_generated_data_vn_units_minified.json
   │  │  │  ├─ vn_only_simplified_json_generated_data_vn_units.json
   │  │  │  └─ vn_only_simplified_json_generated_data_vn_units_minified.json
   │  │  └─ images
   │  │     ├─ 717760.jpg
   │  │     ├─ bin.png
   │  │     ├─ cart.png
   │  │     ├─ daudau.jpg
   │  │     ├─ gundam1.png
   │  │     ├─ gundam2.png
   │  │     ├─ gundam3.png
   │  │     ├─ gundam4.png
   │  │     ├─ home.png
   │  │     ├─ login.png
   │  │     ├─ MoMo_Logo.png
   │  │     ├─ natra.png
   │  │     ├─ new-home.png
   │  │     ├─ vnd.png
   │  │     └─ VNPay_Logo.png
   │  ├─ index.html
   │  ├─ main.server.ts
   │  ├─ main.ts
   │  ├─ model
   │  │  └─ product.model.ts
   │  ├─ server.ts
   │  ├─ services
   │  │  ├─ auth.interceptor.ts
   │  │  ├─ BlogService.ts
   │  │  ├─ cart.service.ts
   │  │  ├─ location.service.ts
   │  │  ├─ notification.service.ts
   │  │  ├─ order.service.ts
   │  │  └─ product.service.ts
   │  ├─ styles.css
   │  └─ _redirects
   ├─ tsconfig.app.json
   ├─ tsconfig.json
   └─ tsconfig.spec.json

```
```
Shop_mo_hinh
├─ Back_end
│  ├─ .idea
│  │  ├─ compiler.xml
│  │  ├─ encodings.xml
│  │  ├─ jarRepositories.xml
│  │  ├─ misc.xml
│  │  ├─ vcs.xml
│  │  └─ workspace.xml
│  ├─ Dockerfile
│  ├─ init.sql
│  ├─ pom.xml
│  ├─ src
│  │  ├─ main
│  │  │  ├─ java
│  │  │  │  └─ com
│  │  │  │     └─ example
│  │  │  │        └─ shopmohinh
│  │  │  │           ├─ configuration
│  │  │  │           │  ├─ ApplicationInitConfig.java
│  │  │  │           │  ├─ CloudinaryConfig.java
│  │  │  │           │  ├─ CustomJwtDecoder.java
│  │  │  │           │  ├─ JwtAuthenticationEntryPoint.java
│  │  │  │           │  ├─ MailConfig.java
│  │  │  │           │  ├─ RedisConfig.java
│  │  │  │           │  ├─ SecurityConfig.java
│  │  │  │           │  ├─ VnpayConfig.java
│  │  │  │           │  └─ WebConfig.java
│  │  │  │           ├─ constant
│  │  │  │           │  ├─ Contant.java
│  │  │  │           │  └─ ProductStatusConstant.java
│  │  │  │           ├─ controller
│  │  │  │           │  ├─ AdminController.java
│  │  │  │           │  ├─ AuthenticationController.java
│  │  │  │           │  ├─ BrandController.java
│  │  │  │           │  ├─ CartDetailController.java
│  │  │  │           │  ├─ CategoryController.java
│  │  │  │           │  ├─ MaterialController.java
│  │  │  │           │  ├─ MomoController.java
│  │  │  │           │  ├─ PaymentController.java
│  │  │  │           │  ├─ PermissionController.java
│  │  │  │           │  ├─ ProductController.java
│  │  │  │           │  ├─ RoleController.java
│  │  │  │           │  ├─ SizeController.java
│  │  │  │           │  └─ UserController.java
│  │  │  │           ├─ dto
│  │  │  │           │  ├─ projection
│  │  │  │           │  │  └─ ProductProjection.java
│  │  │  │           │  ├─ request
│  │  │  │           │  │  ├─ AuthenticationRequest.java
│  │  │  │           │  │  ├─ BrandRequest.java
│  │  │  │           │  │  ├─ CartDetailRequest.java
│  │  │  │           │  │  ├─ CategoryRequest.java
│  │  │  │           │  │  ├─ ImageRequest.java
│  │  │  │           │  │  ├─ IntrospectRequest.java
│  │  │  │           │  │  ├─ LogoutRequest.java
│  │  │  │           │  │  ├─ MaterialRequest.java
│  │  │  │           │  │  ├─ PaymentResquest.java
│  │  │  │           │  │  ├─ PermissionRequest.java
│  │  │  │           │  │  ├─ ProductRequest.java
│  │  │  │           │  │  ├─ RefeshRequest.java
│  │  │  │           │  │  ├─ ResetPasswordRequest.java
│  │  │  │           │  │  ├─ RoleRequest.java
│  │  │  │           │  │  ├─ SizeRequest.java
│  │  │  │           │  │  ├─ UserCreationRequest.java
│  │  │  │           │  │  └─ UserUpdateRequest.java
│  │  │  │           │  ├─ response
│  │  │  │           │  │  ├─ ApiResponse.java
│  │  │  │           │  │  ├─ AuthenticationResponse.java
│  │  │  │           │  │  ├─ BrandResponse.java
│  │  │  │           │  │  ├─ CartDetailResponse.java
│  │  │  │           │  │  ├─ CategoryResponse.java
│  │  │  │           │  │  ├─ ImageResponse.java
│  │  │  │           │  │  ├─ IntrospectResponse.java
│  │  │  │           │  │  ├─ MaterialResponse.java
│  │  │  │           │  │  ├─ PermissionResponse.java
│  │  │  │           │  │  ├─ ProductResponse.java
│  │  │  │           │  │  ├─ RoleResponse.java
│  │  │  │           │  │  ├─ SizeResponse.java
│  │  │  │           │  │  └─ UserResponse.java
│  │  │  │           │  └─ search
│  │  │  │           │     ├─ ProductSearch.java
│  │  │  │           │     └─ SearchDto.java
│  │  │  │           ├─ entity
│  │  │  │           │  ├─ AbtractEntity.java
│  │  │  │           │  ├─ BillDetailEntity.java
│  │  │  │           │  ├─ BillEntity.java
│  │  │  │           │  ├─ BrandEntity.java
│  │  │  │           │  ├─ CartDetailEntity.java
│  │  │  │           │  ├─ CartEntity.java
│  │  │  │           │  ├─ Category.java
│  │  │  │           │  ├─ ImageEntity.java
│  │  │  │           │  ├─ InvalidatedToken.java
│  │  │  │           │  ├─ MaterialEntity.java
│  │  │  │           │  ├─ PasswordResetTokens.java
│  │  │  │           │  ├─ PaymentEntity.java
│  │  │  │           │  ├─ Permission.java
│  │  │  │           │  ├─ Product.java
│  │  │  │           │  ├─ Role.java
│  │  │  │           │  ├─ SizeEntity.java
│  │  │  │           │  └─ User.java
│  │  │  │           ├─ exception
│  │  │  │           │  ├─ AppException.java
│  │  │  │           │  ├─ ErrorCode.java
│  │  │  │           │  └─ GlobalExceptionHandler.java
│  │  │  │           ├─ mapper
│  │  │  │           │  ├─ BrandMapper.java
│  │  │  │           │  ├─ CartDetailMapper.java
│  │  │  │           │  ├─ CategoryMapper.java
│  │  │  │           │  ├─ MaterialMapper.java
│  │  │  │           │  ├─ PermissionMapper.java
│  │  │  │           │  ├─ ProductMapper.java
│  │  │  │           │  ├─ RoleMapper.java
│  │  │  │           │  ├─ SizeMapper.java
│  │  │  │           │  └─ UserMapper.java
│  │  │  │           ├─ repository
│  │  │  │           │  ├─ BrandRepository.java
│  │  │  │           │  ├─ CartDetailRepository.java
│  │  │  │           │  ├─ CartRepository.java
│  │  │  │           │  ├─ CategoryRepository.java
│  │  │  │           │  ├─ ImageRepository.java
│  │  │  │           │  ├─ InvalidatedTokenRepository.java
│  │  │  │           │  ├─ MaterialRepository.java
│  │  │  │           │  ├─ PasswordResetTokensRepository.java
│  │  │  │           │  ├─ PermissionRepository.java
│  │  │  │           │  ├─ ProductRepository.java
│  │  │  │           │  ├─ RoleRepository.java
│  │  │  │           │  ├─ SizeRepository.java
│  │  │  │           │  └─ UserRepository.java
│  │  │  │           ├─ service
│  │  │  │           │  ├─ CartDetailService.java
│  │  │  │           │  └─ impl
│  │  │  │           │     ├─ AuthenticationService.java
│  │  │  │           │     ├─ BrandService.java
│  │  │  │           │     ├─ CartDetailServiceImpl.java
│  │  │  │           │     ├─ CategoryService.java
│  │  │  │           │     ├─ MaterialService.java
│  │  │  │           │     ├─ MomoService.java
│  │  │  │           │     ├─ PasswordResetService.java
│  │  │  │           │     ├─ PermissionService.java
│  │  │  │           │     ├─ ProductService.java
│  │  │  │           │     ├─ RoleService.java
│  │  │  │           │     ├─ SizeService.java
│  │  │  │           │     ├─ UserService.java
│  │  │  │           │     └─ VnpayService.java
│  │  │  │           ├─ ShopmohinhApplication.java
│  │  │  │           └─ util
│  │  │  │              └─ FileUploadUtil.java
│  │  │  └─ resources
│  │  │     ├─ application-docker.properties
│  │  │     └─ application.properties
│  │  └─ test
│  │     └─ java
│  │        └─ com
│  │           └─ example
│  │              └─ shopmohinh
│  │                 └─ ShopmohinhApplicationTests.java
│  └─ target
│     ├─ classes
│     │  ├─ application-docker.properties
│     │  ├─ application.properties
│     │  └─ com
│     │     └─ example
│     │        └─ shopmohinh
│     │           ├─ configuration
│     │           │  ├─ ApplicationInitConfig.class
│     │           │  ├─ CloudinaryConfig.class
│     │           │  ├─ CustomJwtDecoder.class
│     │           │  ├─ JwtAuthenticationEntryPoint.class
│     │           │  ├─ MailConfig.class
│     │           │  ├─ RedisConfig.class
│     │           │  ├─ SecurityConfig.class
│     │           │  ├─ VnpayConfig.class
│     │           │  └─ WebConfig.class
│     │           ├─ constant
│     │           │  ├─ Contant.class
│     │           │  └─ ProductStatusConstant.class
│     │           ├─ controller
│     │           │  ├─ AdminController.class
│     │           │  ├─ AuthenticationController.class
│     │           │  ├─ BrandController.class
│     │           │  ├─ CartDetailController.class
│     │           │  ├─ CategoryController.class
│     │           │  ├─ MaterialController.class
│     │           │  ├─ MomoController.class
│     │           │  ├─ PaymentController.class
│     │           │  ├─ PermissionController.class
│     │           │  ├─ ProductController.class
│     │           │  ├─ RoleController.class
│     │           │  ├─ SizeController.class
│     │           │  └─ UserController.class
│     │           ├─ dto
│     │           │  ├─ projection
│     │           │  │  └─ ProductProjection.class
│     │           │  ├─ request
│     │           │  │  ├─ AuthenticationRequest$AuthenticationRequestBuilder.class
│     │           │  │  ├─ AuthenticationRequest.class
│     │           │  │  ├─ BrandRequest$BrandRequestBuilder.class
│     │           │  │  ├─ BrandRequest.class
│     │           │  │  ├─ CartDetailRequest.class
│     │           │  │  ├─ CategoryRequest$CategoryRequestBuilder.class
│     │           │  │  ├─ CategoryRequest.class
│     │           │  │  ├─ ImageRequest.class
│     │           │  │  ├─ IntrospectRequest$IntrospectRequestBuilder.class
│     │           │  │  ├─ IntrospectRequest.class
│     │           │  │  ├─ LogoutRequest$LogoutRequestBuilder.class
│     │           │  │  ├─ LogoutRequest.class
│     │           │  │  ├─ MaterialRequest$MaterialRequestBuilder.class
│     │           │  │  ├─ MaterialRequest.class
│     │           │  │  ├─ PaymentResquest$PaymentResquestBuilder.class
│     │           │  │  ├─ PaymentResquest.class
│     │           │  │  ├─ PermissionRequest$PermissionRequestBuilder.class
│     │           │  │  ├─ PermissionRequest.class
│     │           │  │  ├─ ProductRequest$ProductRequestBuilder.class
│     │           │  │  ├─ ProductRequest.class
│     │           │  │  ├─ RefeshRequest$RefeshRequestBuilder.class
│     │           │  │  ├─ RefeshRequest.class
│     │           │  │  ├─ ResetPasswordRequest$ResetPasswordRequestBuilder.class
│     │           │  │  ├─ ResetPasswordRequest.class
│     │           │  │  ├─ RoleRequest$RoleRequestBuilder.class
│     │           │  │  ├─ RoleRequest.class
│     │           │  │  ├─ SizeRequest$SizeRequestBuilder.class
│     │           │  │  ├─ SizeRequest.class
│     │           │  │  ├─ UserCreationRequest$UserCreationRequestBuilder.class
│     │           │  │  ├─ UserCreationRequest.class
│     │           │  │  ├─ UserUpdateRequest$UserUpdateRequestBuilder.class
│     │           │  │  └─ UserUpdateRequest.class
│     │           │  ├─ response
│     │           │  │  ├─ ApiResponse$ApiResponseBuilder.class
│     │           │  │  ├─ ApiResponse.class
│     │           │  │  ├─ AuthenticationResponse$AuthenticationResponseBuilder.class
│     │           │  │  ├─ AuthenticationResponse.class
│     │           │  │  ├─ BrandResponse$BrandResponseBuilder.class
│     │           │  │  ├─ BrandResponse.class
│     │           │  │  ├─ CartDetailResponse.class
│     │           │  │  ├─ CategoryResponse$CategoryResponseBuilder.class
│     │           │  │  ├─ CategoryResponse.class
│     │           │  │  ├─ ImageResponse$ImageResponseBuilder.class
│     │           │  │  ├─ ImageResponse.class
│     │           │  │  ├─ IntrospectResponse$IntrospectResponseBuilder.class
│     │           │  │  ├─ IntrospectResponse.class
│     │           │  │  ├─ MaterialResponse$MaterialResponseBuilder.class
│     │           │  │  ├─ MaterialResponse.class
│     │           │  │  ├─ PermissionResponse$PermissionResponseBuilder.class
│     │           │  │  ├─ PermissionResponse.class
│     │           │  │  ├─ ProductResponse$ProductResponseBuilder.class
│     │           │  │  ├─ ProductResponse.class
│     │           │  │  ├─ RoleResponse$RoleResponseBuilder.class
│     │           │  │  ├─ RoleResponse.class
│     │           │  │  ├─ SizeResponse$SizeResponseBuilder.class
│     │           │  │  ├─ SizeResponse.class
│     │           │  │  ├─ UserResponse$UserResponseBuilder.class
│     │           │  │  └─ UserResponse.class
│     │           │  └─ search
│     │           │     ├─ ProductSearch.class
│     │           │     └─ SearchDto.class
│     │           ├─ entity
│     │           │  ├─ AbtractEntity.class
│     │           │  ├─ BillDetailEntity$BillDetailEntityBuilder.class
│     │           │  ├─ BillDetailEntity.class
│     │           │  ├─ BillEntity$BillEntityBuilder.class
│     │           │  ├─ BillEntity.class
│     │           │  ├─ BrandEntity$BrandEntityBuilder.class
│     │           │  ├─ BrandEntity.class
│     │           │  ├─ CartDetailEntity$CartDetailEntityBuilder.class
│     │           │  ├─ CartDetailEntity.class
│     │           │  ├─ CartEntity$CartEntityBuilder.class
│     │           │  ├─ CartEntity.class
│     │           │  ├─ Category$CategoryBuilder.class
│     │           │  ├─ Category.class
│     │           │  ├─ ImageEntity$ImageEntityBuilder.class
│     │           │  ├─ ImageEntity.class
│     │           │  ├─ InvalidatedToken$InvalidatedTokenBuilder.class
│     │           │  ├─ InvalidatedToken.class
│     │           │  ├─ MaterialEntity$MaterialEntityBuilder.class
│     │           │  ├─ MaterialEntity.class
│     │           │  ├─ PasswordResetTokens$PasswordResetTokensBuilder.class
│     │           │  ├─ PasswordResetTokens.class
│     │           │  ├─ PaymentEntity$PaymentEntityBuilder.class
│     │           │  ├─ PaymentEntity.class
│     │           │  ├─ Permission$PermissionBuilder.class
│     │           │  ├─ Permission.class
│     │           │  ├─ Product$ProductBuilder.class
│     │           │  ├─ Product.class
│     │           │  ├─ Role$RoleBuilder.class
│     │           │  ├─ Role.class
│     │           │  ├─ SizeEntity$SizeEntityBuilder.class
│     │           │  ├─ SizeEntity.class
│     │           │  ├─ User$UserBuilder.class
│     │           │  └─ User.class
│     │           ├─ exception
│     │           │  ├─ AppException.class
│     │           │  ├─ ErrorCode.class
│     │           │  └─ GlobalExceptionHandler.class
│     │           ├─ mapper
│     │           │  ├─ BrandMapper.class
│     │           │  ├─ BrandMapperImpl.class
│     │           │  ├─ CartDetailMapper.class
│     │           │  ├─ CartDetailMapperImpl.class
│     │           │  ├─ CategoryMapper.class
│     │           │  ├─ CategoryMapperImpl.class
│     │           │  ├─ MaterialMapper.class
│     │           │  ├─ MaterialMapperImpl.class
│     │           │  ├─ PermissionMapper.class
│     │           │  ├─ PermissionMapperImpl.class
│     │           │  ├─ ProductMapper.class
│     │           │  ├─ ProductMapperImpl.class
│     │           │  ├─ RoleMapper.class
│     │           │  ├─ RoleMapperImpl.class
│     │           │  ├─ SizeMapper.class
│     │           │  ├─ SizeMapperImpl.class
│     │           │  ├─ UserMapper.class
│     │           │  └─ UserMapperImpl.class
│     │           ├─ repository
│     │           │  ├─ BrandRepository.class
│     │           │  ├─ CartDetailRepository.class
│     │           │  ├─ CartRepository.class
│     │           │  ├─ CategoryRepository.class
│     │           │  ├─ ImageRepository.class
│     │           │  ├─ InvalidatedTokenRepository.class
│     │           │  ├─ MaterialRepository.class
│     │           │  ├─ PasswordResetTokensRepository.class
│     │           │  ├─ PermissionRepository.class
│     │           │  ├─ ProductRepository.class
│     │           │  ├─ RoleRepository.class
│     │           │  ├─ SizeRepository.class
│     │           │  └─ UserRepository.class
│     │           ├─ service
│     │           │  ├─ CartDetailService.class
│     │           │  └─ impl
│     │           │     ├─ AuthenticationService.class
│     │           │     ├─ BrandService.class
│     │           │     ├─ CartDetailServiceImpl.class
│     │           │     ├─ CategoryService.class
│     │           │     ├─ MaterialService.class
│     │           │     ├─ MomoService.class
│     │           │     ├─ PasswordResetService.class
│     │           │     ├─ PermissionService.class
│     │           │     ├─ ProductService.class
│     │           │     ├─ RoleService.class
│     │           │     ├─ SizeService.class
│     │           │     ├─ UserService.class
│     │           │     └─ VnpayService.class
│     │           ├─ ShopmohinhApplication.class
│     │           └─ util
│     │              └─ FileUploadUtil.class
│     ├─ generated-sources
│     │  └─ annotations
│     │     └─ com
│     │        └─ example
│     │           └─ shopmohinh
│     │              └─ mapper
│     │                 ├─ BrandMapperImpl.java
│     │                 ├─ CartDetailMapperImpl.java
│     │                 ├─ CategoryMapperImpl.java
│     │                 ├─ MaterialMapperImpl.java
│     │                 ├─ PermissionMapperImpl.java
│     │                 ├─ ProductMapperImpl.java
│     │                 ├─ RoleMapperImpl.java
│     │                 ├─ SizeMapperImpl.java
│     │                 └─ UserMapperImpl.java
│     ├─ generated-test-sources
│     │  └─ test-annotations
│     └─ test-classes
│        └─ com
│           └─ example
│              └─ shopmohinh
│                 └─ ShopmohinhApplicationTests.class
├─ docker-compose.yml
├─ Front_end
│  ├─ .angular
│  │  └─ cache
│  │     └─ 19.1.6
│  │        └─ angular-basic-project
│  │           ├─ .tsbuildinfo
│  │           ├─ angular-compiler.db
│  │           ├─ angular-compiler.db-lock
│  │           └─ vite
│  │              ├─ deps
│  │              │  ├─ @angular_common.js
│  │              │  ├─ @angular_common.js.map
│  │              │  ├─ @angular_common_http.js
│  │              │  ├─ @angular_common_http.js.map
│  │              │  ├─ @angular_core.js
│  │              │  ├─ @angular_core.js.map
│  │              │  ├─ @angular_core_rxjs-interop.js
│  │              │  ├─ @angular_core_rxjs-interop.js.map
│  │              │  ├─ @angular_forms.js
│  │              │  ├─ @angular_forms.js.map
│  │              │  ├─ @angular_platform-browser.js
│  │              │  ├─ @angular_platform-browser.js.map
│  │              │  ├─ @angular_router.js
│  │              │  ├─ @angular_router.js.map
│  │              │  ├─ chunk-2IAKBV5C.js
│  │              │  ├─ chunk-2IAKBV5C.js.map
│  │              │  ├─ chunk-5TID76VL.js
│  │              │  ├─ chunk-5TID76VL.js.map
│  │              │  ├─ chunk-KOO6HHSS.js
│  │              │  ├─ chunk-KOO6HHSS.js.map
│  │              │  ├─ chunk-VU6X2Q5G.js
│  │              │  ├─ chunk-VU6X2Q5G.js.map
│  │              │  ├─ chunk-X5PQU444.js
│  │              │  ├─ chunk-X5PQU444.js.map
│  │              │  ├─ package.json
│  │              │  ├─ rxjs.js
│  │              │  ├─ rxjs.js.map
│  │              │  └─ _metadata.json
│  │              └─ deps_ssr
│  │                 ├─ @angular_common.js
│  │                 ├─ @angular_common.js.map
│  │                 ├─ @angular_common_http.js
│  │                 ├─ @angular_common_http.js.map
│  │                 ├─ @angular_core.js
│  │                 ├─ @angular_core.js.map
│  │                 ├─ @angular_core_rxjs-interop.js
│  │                 ├─ @angular_core_rxjs-interop.js.map
│  │                 ├─ @angular_forms.js
│  │                 ├─ @angular_forms.js.map
│  │                 ├─ @angular_platform-browser.js
│  │                 ├─ @angular_platform-browser.js.map
│  │                 ├─ @angular_platform-server.js
│  │                 ├─ @angular_platform-server.js.map
│  │                 ├─ @angular_router.js
│  │                 ├─ @angular_router.js.map
│  │                 ├─ @angular_ssr.js
│  │                 ├─ @angular_ssr.js.map
│  │                 ├─ @angular_ssr_node.js
│  │                 ├─ @angular_ssr_node.js.map
│  │                 ├─ chunk-2J4BYE4I.js
│  │                 ├─ chunk-2J4BYE4I.js.map
│  │                 ├─ chunk-AT7LWMXR.js
│  │                 ├─ chunk-AT7LWMXR.js.map
│  │                 ├─ chunk-CWVPAAV7.js
│  │                 ├─ chunk-CWVPAAV7.js.map
│  │                 ├─ chunk-Q2YBGYWZ.js
│  │                 ├─ chunk-Q2YBGYWZ.js.map
│  │                 ├─ chunk-T4XHMJL2.js
│  │                 ├─ chunk-T4XHMJL2.js.map
│  │                 ├─ chunk-YHCV7DAQ.js
│  │                 ├─ chunk-YHCV7DAQ.js.map
│  │                 ├─ chunk-ZE37V5XJ.js
│  │                 ├─ chunk-ZE37V5XJ.js.map
│  │                 ├─ chunk-ZRSGASEU.js
│  │                 ├─ chunk-ZRSGASEU.js.map
│  │                 ├─ chunk-ZY5P5JLT.js
│  │                 ├─ chunk-ZY5P5JLT.js.map
│  │                 ├─ express.js
│  │                 ├─ express.js.map
│  │                 ├─ package.json
│  │                 ├─ rxjs.js
│  │                 ├─ rxjs.js.map
│  │                 ├─ xhr2-TXIMV6CV.js
│  │                 ├─ xhr2-TXIMV6CV.js.map
│  │                 └─ _metadata.json
│  ├─ .editorconfig
│  ├─ angular.json
│  ├─ dist
│  │  └─ angular-basic-project
│  │     ├─ 3rdpartylicenses.txt
│  │     ├─ browser
│  │     │  ├─ assets
│  │     │  │  ├─ data
│  │     │  │  │  ├─ full_json_generated_data_vn_units.json
│  │     │  │  │  ├─ simplified_json_generated_data_vn_units.json
│  │     │  │  │  ├─ simplified_json_generated_data_vn_units_minified.json
│  │     │  │  │  ├─ vn_only_simplified_json_generated_data_vn_units.json
│  │     │  │  │  └─ vn_only_simplified_json_generated_data_vn_units_minified.json
│  │     │  │  └─ images
│  │     │  │     ├─ 717760.jpg
│  │     │  │     ├─ bin.png
│  │     │  │     ├─ cart.png
│  │     │  │     ├─ daudau.jpg
│  │     │  │     ├─ gundam1.png
│  │     │  │     ├─ gundam2.png
│  │     │  │     ├─ gundam3.png
│  │     │  │     ├─ gundam4.png
│  │     │  │     ├─ home.png
│  │     │  │     ├─ login.png
│  │     │  │     ├─ MoMo_Logo.png
│  │     │  │     ├─ natra.png
│  │     │  │     ├─ new-home.png
│  │     │  │     ├─ vnd.png
│  │     │  │     └─ VNPay_Logo.png
│  │     │  ├─ cart
│  │     │  │  └─ index.html
│  │     │  ├─ checkout
│  │     │  │  └─ index.html
│  │     │  ├─ chunk-F5LOGXFQ.js
│  │     │  ├─ chunk-G5N7UGY6.js
│  │     │  ├─ chunk-IV7M3GNX.js
│  │     │  ├─ chunk-J54SYJKW.js
│  │     │  ├─ chunk-K3EL374N.js
│  │     │  ├─ chunk-K3VTEEGP.js
│  │     │  ├─ chunk-LJ3F2RNJ.js
│  │     │  ├─ chunk-M2HG7OXY.js
│  │     │  ├─ chunk-OXSS7JKJ.js
│  │     │  ├─ chunk-RUBDHKR2.js
│  │     │  ├─ chunk-TZP3TU5Q.js
│  │     │  ├─ chunk-VNS6SGYD.js
│  │     │  ├─ chunk-YSIY3LO2.js
│  │     │  ├─ home
│  │     │  │  └─ index.html
│  │     │  ├─ index.csr.html
│  │     │  ├─ index.html
│  │     │  ├─ login
│  │     │  │  └─ index.html
│  │     │  ├─ main-4HF2NDFS.js
│  │     │  ├─ momo-return
│  │     │  │  └─ index.html
│  │     │  ├─ payment-result
│  │     │  │  └─ index.html
│  │     │  ├─ polyfills-FFHMD2TL.js
│  │     │  ├─ register
│  │     │  │  └─ index.html
│  │     │  ├─ styles-UBO7ZRZY.css
│  │     │  └─ vnpay-return
│  │     │     └─ index.html
│  │     ├─ prerendered-routes.json
│  │     └─ server
│  │        ├─ angular-app-engine-manifest.mjs
│  │        ├─ angular-app-manifest.mjs
│  │        ├─ assets-chunks
│  │        │  ├─ cart_index_html.mjs
│  │        │  ├─ checkout_index_html.mjs
│  │        │  ├─ home_index_html.mjs
│  │        │  ├─ index_csr_html.mjs
│  │        │  ├─ index_html.mjs
│  │        │  ├─ index_server_html.mjs
│  │        │  ├─ login_index_html.mjs
│  │        │  ├─ momo-return_index_html.mjs
│  │        │  ├─ payment-result_index_html.mjs
│  │        │  ├─ register_index_html.mjs
│  │        │  ├─ styles-UBO7ZRZY_css.mjs
│  │        │  └─ vnpay-return_index_html.mjs
│  │        ├─ chunk-4A32CHN7.mjs
│  │        ├─ chunk-4C2TAPL5.mjs
│  │        ├─ chunk-5BRXCWC3.mjs
│  │        ├─ chunk-C2ZNL6NZ.mjs
│  │        ├─ chunk-C5RN6ICV.mjs
│  │        ├─ chunk-CHVCOU7S.mjs
│  │        ├─ chunk-EJSJJTUO.mjs
│  │        ├─ chunk-GFUZYSQG.mjs
│  │        ├─ chunk-IWRBA2FL.mjs
│  │        ├─ chunk-O4ZIPSBE.mjs
│  │        ├─ chunk-PQGP6J6H.mjs
│  │        ├─ chunk-QLWWAKXQ.mjs
│  │        ├─ chunk-RRHHSCM3.mjs
│  │        ├─ chunk-TNO4MGIL.mjs
│  │        ├─ chunk-UANXQHSL.mjs
│  │        ├─ chunk-VV2CSWQ6.mjs
│  │        ├─ chunk-X2SEQXRR.mjs
│  │        ├─ index.server.html
│  │        ├─ main.server.mjs
│  │        ├─ polyfills.server.mjs
│  │        └─ server.mjs
│  ├─ Dockerfile
│  ├─ nginx.conf
│  ├─ package-lock.json
│  ├─ package.json
│  ├─ public
│  │  └─ favicon.ico
│  ├─ README.md
│  ├─ src
│  │  ├─ app
│  │  │  ├─ app.component.css
│  │  │  ├─ app.component.html
│  │  │  ├─ app.component.ts
│  │  │  ├─ app.config.server.ts
│  │  │  ├─ app.config.ts
│  │  │  ├─ app.routes.server.ts
│  │  │  ├─ app.routes.ts
│  │  │  ├─ cart
│  │  │  │  ├─ cart.component.css
│  │  │  │  ├─ cart.component.html
│  │  │  │  ├─ cart.component.spec.ts
│  │  │  │  └─ cart.component.ts
│  │  │  ├─ checkout
│  │  │  │  ├─ checkout.component.css
│  │  │  │  ├─ checkout.component.html
│  │  │  │  ├─ checkout.component.spec.ts
│  │  │  │  └─ checkout.component.ts
│  │  │  ├─ create
│  │  │  │  ├─ create.component.css
│  │  │  │  ├─ create.component.html
│  │  │  │  └─ create.component.ts
│  │  │  ├─ detail
│  │  │  │  ├─ detail.component.css
│  │  │  │  ├─ detail.component.html
│  │  │  │  └─ detail.component.ts
│  │  │  ├─ header-layout
│  │  │  │  ├─ header-layout.component.css
│  │  │  │  ├─ header-layout.component.html
│  │  │  │  ├─ header-layout.component.ts
│  │  │  │  └─ pipes
│  │  │  │     ├─ CurrencyPipe.ts
│  │  │  │     └─ UppercasePipe.ts
│  │  │  ├─ home
│  │  │  │  ├─ home.component.css
│  │  │  │  ├─ home.component.html
│  │  │  │  └─ home.component.ts
│  │  │  ├─ interceptor
│  │  │  │  └─ custom.interceptor.ts
│  │  │  ├─ login
│  │  │  │  ├─ login.component.css
│  │  │  │  ├─ login.component.html
│  │  │  │  ├─ login.component.spec.ts
│  │  │  │  └─ login.component.ts
│  │  │  ├─ momo-return
│  │  │  │  └─ momo-return.component.ts
│  │  │  ├─ payment-result
│  │  │  │  ├─ payment-result.component.css
│  │  │  │  ├─ payment-result.component.html
│  │  │  │  ├─ payment-result.component.spec.ts
│  │  │  │  └─ payment-result.component.ts
│  │  │  ├─ product-item
│  │  │  │  ├─ productItem.component.css
│  │  │  │  ├─ productItem.component.html
│  │  │  │  └─ productItem.component.ts
│  │  │  ├─ register
│  │  │  │  ├─ register.component.css
│  │  │  │  ├─ register.component.html
│  │  │  │  ├─ register.component.spec.ts
│  │  │  │  └─ register.component.ts
│  │  │  ├─ shared
│  │  │  │  └─ notification
│  │  │  │     ├─ notification.component.css
│  │  │  │     ├─ notification.component.html
│  │  │  │     └─ notification.component.ts
│  │  │  ├─ types
│  │  │  │  ├─ productItem.ts
│  │  │  │  └─ responseData.ts
│  │  │  └─ vnpay-return
│  │  │     └─ vnpay-return.component.ts
│  │  ├─ assets
│  │  │  ├─ data
│  │  │  │  ├─ full_json_generated_data_vn_units.json
│  │  │  │  ├─ simplified_json_generated_data_vn_units.json
│  │  │  │  ├─ simplified_json_generated_data_vn_units_minified.json
│  │  │  │  ├─ vn_only_simplified_json_generated_data_vn_units.json
│  │  │  │  └─ vn_only_simplified_json_generated_data_vn_units_minified.json
│  │  │  └─ images
│  │  │     ├─ 717760.jpg
│  │  │     ├─ bin.png
│  │  │     ├─ cart.png
│  │  │     ├─ daudau.jpg
│  │  │     ├─ gundam1.png
│  │  │     ├─ gundam2.png
│  │  │     ├─ gundam3.png
│  │  │     ├─ gundam4.png
│  │  │     ├─ home.png
│  │  │     ├─ login.png
│  │  │     ├─ MoMo_Logo.png
│  │  │     ├─ natra.png
│  │  │     ├─ new-home.png
│  │  │     ├─ vnd.png
│  │  │     └─ VNPay_Logo.png
│  │  ├─ environments
│  │  │  ├─ environment.prod.ts
│  │  │  └─ environment.ts
│  │  ├─ index.html
│  │  ├─ main.server.ts
│  │  ├─ main.ts
│  │  ├─ model
│  │  │  └─ product.model.ts
│  │  ├─ server.ts
│  │  ├─ services
│  │  │  ├─ auth.interceptor.ts
│  │  │  ├─ BlogService.ts
│  │  │  ├─ cart.service.ts
│  │  │  ├─ location.service.ts
│  │  │  ├─ notification.service.ts
│  │  │  ├─ order.service.ts
│  │  │  └─ product.service.ts
│  │  ├─ styles.css
│  │  └─ _redirects
│  ├─ tsconfig.app.json
│  ├─ tsconfig.json
│  └─ tsconfig.spec.json
└─ README.md

```
```
Shop_mo_hinh
├─ Back_end
│  ├─ .env
│  ├─ .env.example
│  ├─ .idea
│  │  ├─ compiler.xml
│  │  ├─ encodings.xml
│  │  ├─ jarRepositories.xml
│  │  ├─ misc.xml
│  │  ├─ vcs.xml
│  │  └─ workspace.xml
│  ├─ Dockerfile
│  ├─ init.sql
│  ├─ pom.xml
│  ├─ src
│  │  ├─ main
│  │  │  ├─ java
│  │  │  │  └─ com
│  │  │  │     └─ example
│  │  │  │        └─ shopmohinh
│  │  │  │           ├─ configuration
│  │  │  │           │  ├─ ApplicationInitConfig.java
│  │  │  │           │  ├─ CloudinaryConfig.java
│  │  │  │           │  ├─ CustomJwtDecoder.java
│  │  │  │           │  ├─ EnvConfig.java
│  │  │  │           │  ├─ JwtAuthenticationEntryPoint.java
│  │  │  │           │  ├─ MailConfig.java
│  │  │  │           │  ├─ RedisConfig.java
│  │  │  │           │  ├─ SecurityConfig.java
│  │  │  │           │  ├─ VnpayConfig.java
│  │  │  │           │  └─ WebConfig.java
│  │  │  │           ├─ constant
│  │  │  │           │  ├─ Contant.java
│  │  │  │           │  └─ ProductStatusConstant.java
│  │  │  │           ├─ controller
│  │  │  │           │  ├─ AdminController.java
│  │  │  │           │  ├─ AuthenticationController.java
│  │  │  │           │  ├─ BrandController.java
│  │  │  │           │  ├─ CartDetailController.java
│  │  │  │           │  ├─ CategoryController.java
│  │  │  │           │  ├─ MaterialController.java
│  │  │  │           │  ├─ MomoController.java
│  │  │  │           │  ├─ PaymentController.java
│  │  │  │           │  ├─ PermissionController.java
│  │  │  │           │  ├─ ProductController.java
│  │  │  │           │  ├─ RoleController.java
│  │  │  │           │  ├─ SizeController.java
│  │  │  │           │  └─ UserController.java
│  │  │  │           ├─ dto
│  │  │  │           │  ├─ projection
│  │  │  │           │  │  └─ ProductProjection.java
│  │  │  │           │  ├─ request
│  │  │  │           │  │  ├─ AuthenticationRequest.java
│  │  │  │           │  │  ├─ BrandRequest.java
│  │  │  │           │  │  ├─ CartDetailRequest.java
│  │  │  │           │  │  ├─ CategoryRequest.java
│  │  │  │           │  │  ├─ ImageRequest.java
│  │  │  │           │  │  ├─ IntrospectRequest.java
│  │  │  │           │  │  ├─ LogoutRequest.java
│  │  │  │           │  │  ├─ MaterialRequest.java
│  │  │  │           │  │  ├─ PaymentResquest.java
│  │  │  │           │  │  ├─ PermissionRequest.java
│  │  │  │           │  │  ├─ ProductRequest.java
│  │  │  │           │  │  ├─ RefeshRequest.java
│  │  │  │           │  │  ├─ ResetPasswordRequest.java
│  │  │  │           │  │  ├─ RoleRequest.java
│  │  │  │           │  │  ├─ SizeRequest.java
│  │  │  │           │  │  ├─ UserCreationRequest.java
│  │  │  │           │  │  └─ UserUpdateRequest.java
│  │  │  │           │  ├─ response
│  │  │  │           │  │  ├─ ApiResponse.java
│  │  │  │           │  │  ├─ AuthenticationResponse.java
│  │  │  │           │  │  ├─ BrandResponse.java
│  │  │  │           │  │  ├─ CartDetailResponse.java
│  │  │  │           │  │  ├─ CategoryResponse.java
│  │  │  │           │  │  ├─ ImageResponse.java
│  │  │  │           │  │  ├─ IntrospectResponse.java
│  │  │  │           │  │  ├─ MaterialResponse.java
│  │  │  │           │  │  ├─ PermissionResponse.java
│  │  │  │           │  │  ├─ ProductResponse.java
│  │  │  │           │  │  ├─ RoleResponse.java
│  │  │  │           │  │  ├─ SizeResponse.java
│  │  │  │           │  │  └─ UserResponse.java
│  │  │  │           │  └─ search
│  │  │  │           │     ├─ ProductSearch.java
│  │  │  │           │     └─ SearchDto.java
│  │  │  │           ├─ entity
│  │  │  │           │  ├─ AbtractEntity.java
│  │  │  │           │  ├─ BillDetailEntity.java
│  │  │  │           │  ├─ BillEntity.java
│  │  │  │           │  ├─ BrandEntity.java
│  │  │  │           │  ├─ CartDetailEntity.java
│  │  │  │           │  ├─ CartEntity.java
│  │  │  │           │  ├─ Category.java
│  │  │  │           │  ├─ ImageEntity.java
│  │  │  │           │  ├─ InvalidatedToken.java
│  │  │  │           │  ├─ MaterialEntity.java
│  │  │  │           │  ├─ PasswordResetTokens.java
│  │  │  │           │  ├─ PaymentEntity.java
│  │  │  │           │  ├─ Permission.java
│  │  │  │           │  ├─ Product.java
│  │  │  │           │  ├─ Role.java
│  │  │  │           │  ├─ SizeEntity.java
│  │  │  │           │  └─ User.java
│  │  │  │           ├─ exception
│  │  │  │           │  ├─ AppException.java
│  │  │  │           │  ├─ ErrorCode.java
│  │  │  │           │  └─ GlobalExceptionHandler.java
│  │  │  │           ├─ mapper
│  │  │  │           │  ├─ BrandMapper.java
│  │  │  │           │  ├─ CartDetailMapper.java
│  │  │  │           │  ├─ CategoryMapper.java
│  │  │  │           │  ├─ MaterialMapper.java
│  │  │  │           │  ├─ PermissionMapper.java
│  │  │  │           │  ├─ ProductMapper.java
│  │  │  │           │  ├─ RoleMapper.java
│  │  │  │           │  ├─ SizeMapper.java
│  │  │  │           │  └─ UserMapper.java
│  │  │  │           ├─ repository
│  │  │  │           │  ├─ BrandRepository.java
│  │  │  │           │  ├─ CartDetailRepository.java
│  │  │  │           │  ├─ CartRepository.java
│  │  │  │           │  ├─ CategoryRepository.java
│  │  │  │           │  ├─ ImageRepository.java
│  │  │  │           │  ├─ InvalidatedTokenRepository.java
│  │  │  │           │  ├─ MaterialRepository.java
│  │  │  │           │  ├─ PasswordResetTokensRepository.java
│  │  │  │           │  ├─ PermissionRepository.java
│  │  │  │           │  ├─ ProductRepository.java
│  │  │  │           │  ├─ RoleRepository.java
│  │  │  │           │  ├─ SizeRepository.java
│  │  │  │           │  └─ UserRepository.java
│  │  │  │           ├─ service
│  │  │  │           │  ├─ CartDetailService.java
│  │  │  │           │  └─ impl
│  │  │  │           │     ├─ AuthenticationService.java
│  │  │  │           │     ├─ BrandService.java
│  │  │  │           │     ├─ CartDetailServiceImpl.java
│  │  │  │           │     ├─ CategoryService.java
│  │  │  │           │     ├─ MaterialService.java
│  │  │  │           │     ├─ MomoService.java
│  │  │  │           │     ├─ PasswordResetService.java
│  │  │  │           │     ├─ PermissionService.java
│  │  │  │           │     ├─ ProductService.java
│  │  │  │           │     ├─ RoleService.java
│  │  │  │           │     ├─ SizeService.java
│  │  │  │           │     ├─ UserService.java
│  │  │  │           │     └─ VnpayService.java
│  │  │  │           ├─ ShopmohinhApplication.java
│  │  │  │           └─ util
│  │  │  │              └─ FileUploadUtil.java
│  │  │  └─ resources
│  │  │     ├─ application-docker.properties
│  │  │     └─ application.properties
│  │  └─ test
│  │     └─ java
│  │        └─ com
│  │           └─ example
│  │              └─ shopmohinh
│  │                 ├─ ShopmohinhApplicationTests.java
│  │                 └─ TestEnv.java
│  └─ target
│     ├─ classes
│     │  ├─ application-docker.properties
│     │  ├─ application.properties
│     │  └─ com
│     │     └─ example
│     │        └─ shopmohinh
│     │           ├─ configuration
│     │           │  ├─ ApplicationInitConfig.class
│     │           │  ├─ CloudinaryConfig.class
│     │           │  ├─ CustomJwtDecoder.class
│     │           │  ├─ EnvConfig.class
│     │           │  ├─ JwtAuthenticationEntryPoint.class
│     │           │  ├─ MailConfig.class
│     │           │  ├─ RedisConfig.class
│     │           │  ├─ SecurityConfig.class
│     │           │  ├─ VnpayConfig.class
│     │           │  └─ WebConfig.class
│     │           ├─ constant
│     │           │  ├─ Contant.class
│     │           │  └─ ProductStatusConstant.class
│     │           ├─ controller
│     │           │  ├─ AdminController.class
│     │           │  ├─ AuthenticationController.class
│     │           │  ├─ BrandController.class
│     │           │  ├─ CartDetailController.class
│     │           │  ├─ CategoryController.class
│     │           │  ├─ MaterialController.class
│     │           │  ├─ MomoController.class
│     │           │  ├─ PaymentController.class
│     │           │  ├─ PermissionController.class
│     │           │  ├─ ProductController.class
│     │           │  ├─ RoleController.class
│     │           │  ├─ SizeController.class
│     │           │  └─ UserController.class
│     │           ├─ dto
│     │           │  ├─ projection
│     │           │  │  └─ ProductProjection.class
│     │           │  ├─ request
│     │           │  │  ├─ AuthenticationRequest$AuthenticationRequestBuilder.class
│     │           │  │  ├─ AuthenticationRequest.class
│     │           │  │  ├─ BrandRequest$BrandRequestBuilder.class
│     │           │  │  ├─ BrandRequest.class
│     │           │  │  ├─ CartDetailRequest.class
│     │           │  │  ├─ CategoryRequest$CategoryRequestBuilder.class
│     │           │  │  ├─ CategoryRequest.class
│     │           │  │  ├─ ImageRequest.class
│     │           │  │  ├─ IntrospectRequest$IntrospectRequestBuilder.class
│     │           │  │  ├─ IntrospectRequest.class
│     │           │  │  ├─ LogoutRequest$LogoutRequestBuilder.class
│     │           │  │  ├─ LogoutRequest.class
│     │           │  │  ├─ MaterialRequest$MaterialRequestBuilder.class
│     │           │  │  ├─ MaterialRequest.class
│     │           │  │  ├─ PaymentResquest$PaymentResquestBuilder.class
│     │           │  │  ├─ PaymentResquest.class
│     │           │  │  ├─ PermissionRequest$PermissionRequestBuilder.class
│     │           │  │  ├─ PermissionRequest.class
│     │           │  │  ├─ ProductRequest$ProductRequestBuilder.class
│     │           │  │  ├─ ProductRequest.class
│     │           │  │  ├─ RefeshRequest$RefeshRequestBuilder.class
│     │           │  │  ├─ RefeshRequest.class
│     │           │  │  ├─ ResetPasswordRequest$ResetPasswordRequestBuilder.class
│     │           │  │  ├─ ResetPasswordRequest.class
│     │           │  │  ├─ RoleRequest$RoleRequestBuilder.class
│     │           │  │  ├─ RoleRequest.class
│     │           │  │  ├─ SizeRequest$SizeRequestBuilder.class
│     │           │  │  ├─ SizeRequest.class
│     │           │  │  ├─ UserCreationRequest$UserCreationRequestBuilder.class
│     │           │  │  ├─ UserCreationRequest.class
│     │           │  │  ├─ UserUpdateRequest$UserUpdateRequestBuilder.class
│     │           │  │  └─ UserUpdateRequest.class
│     │           │  ├─ response
│     │           │  │  ├─ ApiResponse$ApiResponseBuilder.class
│     │           │  │  ├─ ApiResponse.class
│     │           │  │  ├─ AuthenticationResponse$AuthenticationResponseBuilder.class
│     │           │  │  ├─ AuthenticationResponse.class
│     │           │  │  ├─ BrandResponse$BrandResponseBuilder.class
│     │           │  │  ├─ BrandResponse.class
│     │           │  │  ├─ CartDetailResponse.class
│     │           │  │  ├─ CategoryResponse$CategoryResponseBuilder.class
│     │           │  │  ├─ CategoryResponse.class
│     │           │  │  ├─ ImageResponse$ImageResponseBuilder.class
│     │           │  │  ├─ ImageResponse.class
│     │           │  │  ├─ IntrospectResponse$IntrospectResponseBuilder.class
│     │           │  │  ├─ IntrospectResponse.class
│     │           │  │  ├─ MaterialResponse$MaterialResponseBuilder.class
│     │           │  │  ├─ MaterialResponse.class
│     │           │  │  ├─ PermissionResponse$PermissionResponseBuilder.class
│     │           │  │  ├─ PermissionResponse.class
│     │           │  │  ├─ ProductResponse$ProductResponseBuilder.class
│     │           │  │  ├─ ProductResponse.class
│     │           │  │  ├─ RoleResponse$RoleResponseBuilder.class
│     │           │  │  ├─ RoleResponse.class
│     │           │  │  ├─ SizeResponse$SizeResponseBuilder.class
│     │           │  │  ├─ SizeResponse.class
│     │           │  │  ├─ UserResponse$UserResponseBuilder.class
│     │           │  │  └─ UserResponse.class
│     │           │  └─ search
│     │           │     ├─ ProductSearch.class
│     │           │     └─ SearchDto.class
│     │           ├─ entity
│     │           │  ├─ AbtractEntity.class
│     │           │  ├─ BillDetailEntity$BillDetailEntityBuilder.class
│     │           │  ├─ BillDetailEntity.class
│     │           │  ├─ BillEntity$BillEntityBuilder.class
│     │           │  ├─ BillEntity.class
│     │           │  ├─ BrandEntity$BrandEntityBuilder.class
│     │           │  ├─ BrandEntity.class
│     │           │  ├─ CartDetailEntity$CartDetailEntityBuilder.class
│     │           │  ├─ CartDetailEntity.class
│     │           │  ├─ CartEntity$CartEntityBuilder.class
│     │           │  ├─ CartEntity.class
│     │           │  ├─ Category$CategoryBuilder.class
│     │           │  ├─ Category.class
│     │           │  ├─ ImageEntity$ImageEntityBuilder.class
│     │           │  ├─ ImageEntity.class
│     │           │  ├─ InvalidatedToken$InvalidatedTokenBuilder.class
│     │           │  ├─ InvalidatedToken.class
│     │           │  ├─ MaterialEntity$MaterialEntityBuilder.class
│     │           │  ├─ MaterialEntity.class
│     │           │  ├─ PasswordResetTokens$PasswordResetTokensBuilder.class
│     │           │  ├─ PasswordResetTokens.class
│     │           │  ├─ PaymentEntity$PaymentEntityBuilder.class
│     │           │  ├─ PaymentEntity.class
│     │           │  ├─ Permission$PermissionBuilder.class
│     │           │  ├─ Permission.class
│     │           │  ├─ Product$ProductBuilder.class
│     │           │  ├─ Product.class
│     │           │  ├─ Role$RoleBuilder.class
│     │           │  ├─ Role.class
│     │           │  ├─ SizeEntity$SizeEntityBuilder.class
│     │           │  ├─ SizeEntity.class
│     │           │  ├─ User$UserBuilder.class
│     │           │  └─ User.class
│     │           ├─ exception
│     │           │  ├─ AppException.class
│     │           │  ├─ ErrorCode.class
│     │           │  └─ GlobalExceptionHandler.class
│     │           ├─ mapper
│     │           │  ├─ BrandMapper.class
│     │           │  ├─ BrandMapperImpl.class
│     │           │  ├─ CartDetailMapper.class
│     │           │  ├─ CartDetailMapperImpl.class
│     │           │  ├─ CategoryMapper.class
│     │           │  ├─ CategoryMapperImpl.class
│     │           │  ├─ MaterialMapper.class
│     │           │  ├─ MaterialMapperImpl.class
│     │           │  ├─ PermissionMapper.class
│     │           │  ├─ PermissionMapperImpl.class
│     │           │  ├─ ProductMapper.class
│     │           │  ├─ ProductMapperImpl.class
│     │           │  ├─ RoleMapper.class
│     │           │  ├─ RoleMapperImpl.class
│     │           │  ├─ SizeMapper.class
│     │           │  ├─ SizeMapperImpl.class
│     │           │  ├─ UserMapper.class
│     │           │  └─ UserMapperImpl.class
│     │           ├─ repository
│     │           │  ├─ BrandRepository.class
│     │           │  ├─ CartDetailRepository.class
│     │           │  ├─ CartRepository.class
│     │           │  ├─ CategoryRepository.class
│     │           │  ├─ ImageRepository.class
│     │           │  ├─ InvalidatedTokenRepository.class
│     │           │  ├─ MaterialRepository.class
│     │           │  ├─ PasswordResetTokensRepository.class
│     │           │  ├─ PermissionRepository.class
│     │           │  ├─ ProductRepository.class
│     │           │  ├─ RoleRepository.class
│     │           │  ├─ SizeRepository.class
│     │           │  └─ UserRepository.class
│     │           ├─ service
│     │           │  ├─ CartDetailService.class
│     │           │  └─ impl
│     │           │     ├─ AuthenticationService.class
│     │           │     ├─ BrandService.class
│     │           │     ├─ CartDetailServiceImpl.class
│     │           │     ├─ CategoryService.class
│     │           │     ├─ MaterialService.class
│     │           │     ├─ MomoService.class
│     │           │     ├─ PasswordResetService.class
│     │           │     ├─ PermissionService.class
│     │           │     ├─ ProductService.class
│     │           │     ├─ RoleService.class
│     │           │     ├─ SizeService.class
│     │           │     ├─ UserService.class
│     │           │     └─ VnpayService.class
│     │           ├─ ShopmohinhApplication.class
│     │           └─ util
│     │              └─ FileUploadUtil.class
│     ├─ generated-sources
│     │  └─ annotations
│     │     └─ com
│     │        └─ example
│     │           └─ shopmohinh
│     │              └─ mapper
│     │                 ├─ BrandMapperImpl.java
│     │                 ├─ CartDetailMapperImpl.java
│     │                 ├─ CategoryMapperImpl.java
│     │                 ├─ MaterialMapperImpl.java
│     │                 ├─ PermissionMapperImpl.java
│     │                 ├─ ProductMapperImpl.java
│     │                 ├─ RoleMapperImpl.java
│     │                 ├─ SizeMapperImpl.java
│     │                 └─ UserMapperImpl.java
│     ├─ generated-test-sources
│     │  └─ test-annotations
│     └─ test-classes
│        └─ com
│           └─ example
│              └─ shopmohinh
│                 ├─ ShopmohinhApplicationTests.class
│                 └─ TestEnv.class
├─ docker-compose.yml
├─ Front_end
│  ├─ .angular
│  │  └─ cache
│  │     └─ 19.1.6
│  │        └─ angular-basic-project
│  │           ├─ .tsbuildinfo
│  │           ├─ angular-compiler.db
│  │           ├─ angular-compiler.db-lock
│  │           └─ vite
│  │              ├─ deps
│  │              │  ├─ @angular_common.js
│  │              │  ├─ @angular_common.js.map
│  │              │  ├─ @angular_common_http.js
│  │              │  ├─ @angular_common_http.js.map
│  │              │  ├─ @angular_core.js
│  │              │  ├─ @angular_core.js.map
│  │              │  ├─ @angular_core_rxjs-interop.js
│  │              │  ├─ @angular_core_rxjs-interop.js.map
│  │              │  ├─ @angular_forms.js
│  │              │  ├─ @angular_forms.js.map
│  │              │  ├─ @angular_platform-browser.js
│  │              │  ├─ @angular_platform-browser.js.map
│  │              │  ├─ @angular_router.js
│  │              │  ├─ @angular_router.js.map
│  │              │  ├─ chunk-2IAKBV5C.js
│  │              │  ├─ chunk-2IAKBV5C.js.map
│  │              │  ├─ chunk-5TID76VL.js
│  │              │  ├─ chunk-5TID76VL.js.map
│  │              │  ├─ chunk-KOO6HHSS.js
│  │              │  ├─ chunk-KOO6HHSS.js.map
│  │              │  ├─ chunk-VU6X2Q5G.js
│  │              │  ├─ chunk-VU6X2Q5G.js.map
│  │              │  ├─ chunk-X5PQU444.js
│  │              │  ├─ chunk-X5PQU444.js.map
│  │              │  ├─ package.json
│  │              │  ├─ rxjs.js
│  │              │  ├─ rxjs.js.map
│  │              │  └─ _metadata.json
│  │              └─ deps_ssr
│  │                 ├─ @angular_common.js
│  │                 ├─ @angular_common.js.map
│  │                 ├─ @angular_common_http.js
│  │                 ├─ @angular_common_http.js.map
│  │                 ├─ @angular_core.js
│  │                 ├─ @angular_core.js.map
│  │                 ├─ @angular_core_rxjs-interop.js
│  │                 ├─ @angular_core_rxjs-interop.js.map
│  │                 ├─ @angular_forms.js
│  │                 ├─ @angular_forms.js.map
│  │                 ├─ @angular_platform-browser.js
│  │                 ├─ @angular_platform-browser.js.map
│  │                 ├─ @angular_platform-server.js
│  │                 ├─ @angular_platform-server.js.map
│  │                 ├─ @angular_router.js
│  │                 ├─ @angular_router.js.map
│  │                 ├─ @angular_ssr.js
│  │                 ├─ @angular_ssr.js.map
│  │                 ├─ @angular_ssr_node.js
│  │                 ├─ @angular_ssr_node.js.map
│  │                 ├─ chunk-2J4BYE4I.js
│  │                 ├─ chunk-2J4BYE4I.js.map
│  │                 ├─ chunk-AT7LWMXR.js
│  │                 ├─ chunk-AT7LWMXR.js.map
│  │                 ├─ chunk-CWVPAAV7.js
│  │                 ├─ chunk-CWVPAAV7.js.map
│  │                 ├─ chunk-Q2YBGYWZ.js
│  │                 ├─ chunk-Q2YBGYWZ.js.map
│  │                 ├─ chunk-T4XHMJL2.js
│  │                 ├─ chunk-T4XHMJL2.js.map
│  │                 ├─ chunk-YHCV7DAQ.js
│  │                 ├─ chunk-YHCV7DAQ.js.map
│  │                 ├─ chunk-ZE37V5XJ.js
│  │                 ├─ chunk-ZE37V5XJ.js.map
│  │                 ├─ chunk-ZRSGASEU.js
│  │                 ├─ chunk-ZRSGASEU.js.map
│  │                 ├─ chunk-ZY5P5JLT.js
│  │                 ├─ chunk-ZY5P5JLT.js.map
│  │                 ├─ express.js
│  │                 ├─ express.js.map
│  │                 ├─ package.json
│  │                 ├─ rxjs.js
│  │                 ├─ rxjs.js.map
│  │                 ├─ xhr2-TXIMV6CV.js
│  │                 ├─ xhr2-TXIMV6CV.js.map
│  │                 └─ _metadata.json
│  ├─ .editorconfig
│  ├─ angular.json
│  ├─ dist
│  │  └─ angular-basic-project
│  │     ├─ 3rdpartylicenses.txt
│  │     ├─ browser
│  │     │  ├─ assets
│  │     │  │  ├─ data
│  │     │  │  │  ├─ full_json_generated_data_vn_units.json
│  │     │  │  │  ├─ simplified_json_generated_data_vn_units.json
│  │     │  │  │  ├─ simplified_json_generated_data_vn_units_minified.json
│  │     │  │  │  ├─ vn_only_simplified_json_generated_data_vn_units.json
│  │     │  │  │  └─ vn_only_simplified_json_generated_data_vn_units_minified.json
│  │     │  │  └─ images
│  │     │  │     ├─ 717760.jpg
│  │     │  │     ├─ bin.png
│  │     │  │     ├─ cart.png
│  │     │  │     ├─ daudau.jpg
│  │     │  │     ├─ gundam1.png
│  │     │  │     ├─ gundam2.png
│  │     │  │     ├─ gundam3.png
│  │     │  │     ├─ gundam4.png
│  │     │  │     ├─ home.png
│  │     │  │     ├─ login.png
│  │     │  │     ├─ MoMo_Logo.png
│  │     │  │     ├─ natra.png
│  │     │  │     ├─ new-home.png
│  │     │  │     ├─ vnd.png
│  │     │  │     └─ VNPay_Logo.png
│  │     │  ├─ cart
│  │     │  │  └─ index.html
│  │     │  ├─ checkout
│  │     │  │  └─ index.html
│  │     │  ├─ chunk-F5LOGXFQ.js
│  │     │  ├─ chunk-G5N7UGY6.js
│  │     │  ├─ chunk-IV7M3GNX.js
│  │     │  ├─ chunk-J54SYJKW.js
│  │     │  ├─ chunk-K3EL374N.js
│  │     │  ├─ chunk-K3VTEEGP.js
│  │     │  ├─ chunk-LJ3F2RNJ.js
│  │     │  ├─ chunk-M2HG7OXY.js
│  │     │  ├─ chunk-OXSS7JKJ.js
│  │     │  ├─ chunk-RUBDHKR2.js
│  │     │  ├─ chunk-TZP3TU5Q.js
│  │     │  ├─ chunk-VNS6SGYD.js
│  │     │  ├─ chunk-YSIY3LO2.js
│  │     │  ├─ home
│  │     │  │  └─ index.html
│  │     │  ├─ index.csr.html
│  │     │  ├─ index.html
│  │     │  ├─ login
│  │     │  │  └─ index.html
│  │     │  ├─ main-4HF2NDFS.js
│  │     │  ├─ momo-return
│  │     │  │  └─ index.html
│  │     │  ├─ payment-result
│  │     │  │  └─ index.html
│  │     │  ├─ polyfills-FFHMD2TL.js
│  │     │  ├─ register
│  │     │  │  └─ index.html
│  │     │  ├─ styles-UBO7ZRZY.css
│  │     │  └─ vnpay-return
│  │     │     └─ index.html
│  │     ├─ prerendered-routes.json
│  │     └─ server
│  │        ├─ angular-app-engine-manifest.mjs
│  │        ├─ angular-app-manifest.mjs
│  │        ├─ assets-chunks
│  │        │  ├─ cart_index_html.mjs
│  │        │  ├─ checkout_index_html.mjs
│  │        │  ├─ home_index_html.mjs
│  │        │  ├─ index_csr_html.mjs
│  │        │  ├─ index_html.mjs
│  │        │  ├─ index_server_html.mjs
│  │        │  ├─ login_index_html.mjs
│  │        │  ├─ momo-return_index_html.mjs
│  │        │  ├─ payment-result_index_html.mjs
│  │        │  ├─ register_index_html.mjs
│  │        │  ├─ styles-UBO7ZRZY_css.mjs
│  │        │  └─ vnpay-return_index_html.mjs
│  │        ├─ chunk-4A32CHN7.mjs
│  │        ├─ chunk-4C2TAPL5.mjs
│  │        ├─ chunk-5BRXCWC3.mjs
│  │        ├─ chunk-C2ZNL6NZ.mjs
│  │        ├─ chunk-C5RN6ICV.mjs
│  │        ├─ chunk-CHVCOU7S.mjs
│  │        ├─ chunk-EJSJJTUO.mjs
│  │        ├─ chunk-GFUZYSQG.mjs
│  │        ├─ chunk-IWRBA2FL.mjs
│  │        ├─ chunk-O4ZIPSBE.mjs
│  │        ├─ chunk-PQGP6J6H.mjs
│  │        ├─ chunk-QLWWAKXQ.mjs
│  │        ├─ chunk-RRHHSCM3.mjs
│  │        ├─ chunk-TNO4MGIL.mjs
│  │        ├─ chunk-UANXQHSL.mjs
│  │        ├─ chunk-VV2CSWQ6.mjs
│  │        ├─ chunk-X2SEQXRR.mjs
│  │        ├─ index.server.html
│  │        ├─ main.server.mjs
│  │        ├─ polyfills.server.mjs
│  │        └─ server.mjs
│  ├─ Dockerfile
│  ├─ nginx.conf
│  ├─ package-lock.json
│  ├─ package.json
│  ├─ public
│  │  └─ favicon.ico
│  ├─ README.md
│  ├─ src
│  │  ├─ app
│  │  │  ├─ app.component.css
│  │  │  ├─ app.component.html
│  │  │  ├─ app.component.ts
│  │  │  ├─ app.config.server.ts
│  │  │  ├─ app.config.ts
│  │  │  ├─ app.routes.server.ts
│  │  │  ├─ app.routes.ts
│  │  │  ├─ cart
│  │  │  │  ├─ cart.component.css
│  │  │  │  ├─ cart.component.html
│  │  │  │  ├─ cart.component.spec.ts
│  │  │  │  └─ cart.component.ts
│  │  │  ├─ checkout
│  │  │  │  ├─ checkout.component.css
│  │  │  │  ├─ checkout.component.html
│  │  │  │  ├─ checkout.component.spec.ts
│  │  │  │  └─ checkout.component.ts
│  │  │  ├─ create
│  │  │  │  ├─ create.component.css
│  │  │  │  ├─ create.component.html
│  │  │  │  └─ create.component.ts
│  │  │  ├─ detail
│  │  │  │  ├─ detail.component.css
│  │  │  │  ├─ detail.component.html
│  │  │  │  └─ detail.component.ts
│  │  │  ├─ header-layout
│  │  │  │  ├─ header-layout.component.css
│  │  │  │  ├─ header-layout.component.html
│  │  │  │  ├─ header-layout.component.ts
│  │  │  │  └─ pipes
│  │  │  │     ├─ CurrencyPipe.ts
│  │  │  │     └─ UppercasePipe.ts
│  │  │  ├─ home
│  │  │  │  ├─ home.component.css
│  │  │  │  ├─ home.component.html
│  │  │  │  └─ home.component.ts
│  │  │  ├─ interceptor
│  │  │  │  └─ custom.interceptor.ts
│  │  │  ├─ login
│  │  │  │  ├─ login.component.css
│  │  │  │  ├─ login.component.html
│  │  │  │  ├─ login.component.spec.ts
│  │  │  │  └─ login.component.ts
│  │  │  ├─ momo-return
│  │  │  │  └─ momo-return.component.ts
│  │  │  ├─ payment-result
│  │  │  │  ├─ payment-result.component.css
│  │  │  │  ├─ payment-result.component.html
│  │  │  │  ├─ payment-result.component.spec.ts
│  │  │  │  └─ payment-result.component.ts
│  │  │  ├─ product-item
│  │  │  │  ├─ productItem.component.css
│  │  │  │  ├─ productItem.component.html
│  │  │  │  └─ productItem.component.ts
│  │  │  ├─ register
│  │  │  │  ├─ register.component.css
│  │  │  │  ├─ register.component.html
│  │  │  │  ├─ register.component.spec.ts
│  │  │  │  └─ register.component.ts
│  │  │  ├─ shared
│  │  │  │  └─ notification
│  │  │  │     ├─ notification.component.css
│  │  │  │     ├─ notification.component.html
│  │  │  │     └─ notification.component.ts
│  │  │  ├─ types
│  │  │  │  ├─ productItem.ts
│  │  │  │  └─ responseData.ts
│  │  │  └─ vnpay-return
│  │  │     └─ vnpay-return.component.ts
│  │  ├─ assets
│  │  │  ├─ data
│  │  │  │  ├─ full_json_generated_data_vn_units.json
│  │  │  │  ├─ simplified_json_generated_data_vn_units.json
│  │  │  │  ├─ simplified_json_generated_data_vn_units_minified.json
│  │  │  │  ├─ vn_only_simplified_json_generated_data_vn_units.json
│  │  │  │  └─ vn_only_simplified_json_generated_data_vn_units_minified.json
│  │  │  └─ images
│  │  │     ├─ 717760.jpg
│  │  │     ├─ bin.png
│  │  │     ├─ cart.png
│  │  │     ├─ home.png
│  │  │     ├─ login.png
│  │  │     ├─ MoMo_Logo.png
│  │  │     ├─ natra.png
│  │  │     ├─ new-home.png
│  │  │     ├─ vnd.png
│  │  │     └─ VNPay_Logo.png
│  │  ├─ environments
│  │  │  ├─ environment.prod.ts
│  │  │  └─ environment.ts
│  │  ├─ index.html
│  │  ├─ main.server.ts
│  │  ├─ main.ts
│  │  ├─ model
│  │  │  └─ product.model.ts
│  │  ├─ server.ts
│  │  ├─ services
│  │  │  ├─ auth.interceptor.ts
│  │  │  ├─ BlogService.ts
│  │  │  ├─ cart.service.ts
│  │  │  ├─ location.service.ts
│  │  │  ├─ notification.service.ts
│  │  │  ├─ order.service.ts
│  │  │  └─ product.service.ts
│  │  ├─ styles.css
│  │  └─ _redirects
│  ├─ tsconfig.app.json
│  ├─ tsconfig.json
│  └─ tsconfig.spec.json
└─ README.md

```