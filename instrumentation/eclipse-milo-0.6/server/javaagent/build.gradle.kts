plugins {
  id("otel.javaagent-instrumentation")
}
muzzle {
  // Only allow version 0.6.5 of the sdk-client module to pass the muzzle check
  pass {
    group.set("org.eclipse.milo")
    module.set("sdk-client")
    versions.set("[0.6.5,0.6.5]") // Only allow version 0.6.5
  }

  // Fail all other versions
  fail {
    group.set("org.eclipse.milo")
    module.set("sdk-client")
    versions.set("[,0.6.5)") // Fail all versions before 0.6.5
    versions.set("[0.6.6,)") // Fail all versions after 0.6.5
  }

  // Assert that only version 0.6.5 is supported and others should fail
  pass {
    assertInverse.set(true) // Ensures that versions outside the defined range will fail
  }
}

dependencies {

  // Required for creating extensions for the Java agent
  implementation(project(":javaagent-extension-api"))

  // Compile-time dependency for Eclipse Milo
  compileOnly("org.eclipse.milo:sdk-server:0.6.5") // Replace with the Milo version you're using

  // Dependencies for testing
  testImplementation(project(":testing-common"))
  testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}
