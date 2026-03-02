// Variables required
float walkDistance; // The total distance walked (increases while moving)
float walkDistancePrev; // Distance from the previous frame
float viewBobbingIntensity; // The amplitude (how high it shakes)
float cameraYaw; // Current camera rotation

// Every Frame (Update loop)
void UpdateViewBobbing(float deltaTime) {
    // 1. Calculate how much the player moved this frame
    float deltaDistance = walkDistance - walkDistancePrev;
    // 'walkDistance' continues to increase in Minecraft
    
    // 2. Apply sine waves for movement
    // Vertical is faster (2x frequency) than horizontal
    float yOffset = (float)(Math.sin(walkDistance * 0.6f) * viewBobbingIntensity);
    float xOffset = (float)(Math.cos(walkDistance * 0.3f) * viewBobbingIntensity * 0.5f);

    // 3. Apply to Camera Transform (assuming 1st person)
    // The camera should translate based on the sin calculations
    camera.position.y += yOffset;
    camera.position.x += xOffset;
    
    // 4. Update Previous Distance
    walkDistancePrev = walkDistance;
}
