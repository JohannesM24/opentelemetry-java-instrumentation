plugins {
  id("otel.javaagent-instrumentation")
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
